package ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClosedShell extends ConnectedFaceSet implements StepShapes {

    public ClosedShell(String name, Set<Face> setOfFaces) {
        super(name,setOfFaces);
        drawingShell();
    }

    private void drawingShell() {
        for (Face face : setOfFaces){
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

                                   System.out.println("Start: " + point.get(CartasianAxisE.X) + "," + point.get(CartasianAxisE.Y) + "," + point.get(CartasianAxisE.Z) + "," + "End: " + pointE.get(CartasianAxisE.X) + "," + pointE.get(CartasianAxisE.Y) + "," + pointE.get(CartasianAxisE.Z));
                        }}
                     System.out.println("Loop End");
                }
            System.out.println("FACEBOUND End");
        }
        System.out.println("FACES End");
    }


    @Override
    public AP242Code getTyp() {
        return AP242Code.CLOSED_SHELL;
    }
}
