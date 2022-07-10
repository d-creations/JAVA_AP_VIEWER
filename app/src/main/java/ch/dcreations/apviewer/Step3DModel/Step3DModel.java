package ch.dcreations.apviewer.Step3DModel;

import ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet.ClosedShell;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepDrawLine;
import com.sun.javafx.collections.ObservableFloatArrayImpl;
import com.sun.javafx.collections.ObservableIntegerArrayImpl;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableIntegerArray;
import javafx.scene.shape.Line;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.Shape;
import javafx.scene.shape.TriangleMesh;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Step3DModel {

    String data = "";
    Map<Integer,String> dataMap = new TreeMap<>();
    List<Mesh> shapes2D = new ArrayList<>();
    List<Line> lines2d = new ArrayList<>();
    String header = "";

    public void parseTheFile(Reader reader) throws IOException {
        StringBuilder readData = new StringBuilder();
        int charValue;
        System.out.println("The Drawing From Damian ");
        do {
            charValue = reader.read(); // read next char from file
            readData.append((char)charValue);
        } while (charValue != -1); // reached end of file ?
        int DATApos = readData.toString().indexOf("DATA");
        header = readData.substring(0,DATApos);
        data = readData.substring(DATApos,readData.toString().indexOf("ENDSEC",DATApos));
        data = data.replaceAll("\n","").replaceAll("\r","").replaceAll("DATA;","");
        for (String line : data.split(";")){
            line = line.replaceAll(" ","");
            String[] lineSep = line.split("=");
            String number = lineSep[0].replaceAll("#","");
            if(number.length()>0) {
                int numberCode = Integer.parseInt(number);
                dataMap.put(numberCode, lineSep[1]);
            }
        }
        AP242Decoder ap242Decoder = new AP242Decoder(dataMap);
        ap242Decoder.decode();
        for ( ClosedShell closedShell : ap242Decoder.getShells()){
            shapes2D.add(drawMesh(closedShell));
        }
    }

    private Mesh drawMesh(ClosedShell closedShell){
        TriangleMesh mesh = new TriangleMesh();
        List<Map<CartasianAxisE, Double>> pointList = new ArrayList<>();



        for (Face face : closedShell.getSetOfFaces()){
            System.out.println("Faces Start");
            for (FaceBound faceBound : face.getFaceBound()){
                System.out.println("FaceBound Start");
                for(Edge edge : faceBound.getEdgeLoop().getOrientedEdges()){
                    System.out.println("Loop Start");
                    Point pointP = edge.getEdgeStart().ifExistGivePoint();
                    if (pointP != null) {
                        Map<CartasianAxisE, Double> point = pointP.getPoint();
                        Point pointPE = edge.getEdgeEnd().ifExistGivePoint();
                        Map<CartasianAxisE, Double> pointE = pointPE.getPoint();

                        pointList.add(pointP.getPoint());
                        pointList.add(pointPE.getPoint());
                        // Could add Lines
                        System.out.println("Start: " + point.get(CartasianAxisE.X) + "," + point.get(CartasianAxisE.Y) + "," + point.get(CartasianAxisE.Z) + "," + "End: " + pointE.get(CartasianAxisE.X) + "," + pointE.get(CartasianAxisE.Y) + "," + pointE.get(CartasianAxisE.Z));
                    }}
                System.out.println("Loop End_");
            }
            System.out.println("FACEBOUND End_");
        }
        System.out.println("FACES End_");


        ObservableFloatArray vertexArray = new ObservableFloatArrayImpl();
        ObservableIntegerArray facesArray = new ObservableIntegerArrayImpl();

        int i = 0;
        for (Map<CartasianAxisE,Double> vertex : pointList){
            vertexArray.addAll(vertex.get(CartasianAxisE.X).floatValue());
            vertexArray.addAll(vertex.get(CartasianAxisE.Y).floatValue());
            vertexArray.addAll(vertex.get(CartasianAxisE.Z).floatValue());
            facesArray.addAll(i,0);
            i++;
        }
        mesh.getPoints().addAll(// Verticals
                vertexArray
        );
        mesh.getTexCoords().addAll(//textur
            0f,0f//UV1
        );
        mesh.getFaces().addAll(//Faces
                facesArray
                 );
        mesh.getFaceSmoothingGroups().addAll(//smooth
                );

        return mesh;
    }

    public List<Mesh> getShapes2D() {
        return Collections.unmodifiableList(shapes2D);
    }
}
