package ch.dcreations.apviewer.Step3DModel;

import ch.dcreations.apviewer.Step3DModel.StepShapes.StepLine;
import javafx.scene.shape.Shape;

import java.io.*;
import java.util.*;

public class Step3DModel {

    String data = "";
    Map<Integer,String> dataMap = new TreeMap<>();
    List<Shape> shapes2D = new ArrayList<>();
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
    }

    private void drawLine(){
        StepLine stepLine = new StepLine(0,0,0,2,2,2,5);
        shapes2D.add(stepLine);
    }

    public List<Shape> getShapes2D() {
        return Collections.unmodifiableList(shapes2D);
    }
}
