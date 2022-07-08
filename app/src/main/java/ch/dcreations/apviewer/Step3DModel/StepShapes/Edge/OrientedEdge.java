package ch.dcreations.apviewer.Step3DModel.StepShapes.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;

public class OrientedEdge extends Edge implements StepShapes {

    Edge edgeElement;
    Boolean orientation;

    public OrientedEdge(String name, Vertex edgeStart, Vertex edgeEnd, Edge edgeElement, Boolean orientation) {
        super(name,edgeStart,edgeEnd);
        this.edgeElement = edgeElement;
        this.orientation = orientation;
        calculateEdge();
    }

    private void calculateEdge() {
        if(edgeStart.getName().equals("*")) {
            edgeStart = edgeElement.getEdgeStart();
        }else {
            System.err.println(edgeStart.getName());
        }if(edgeEnd.getName().equals("*")){
            edgeEnd = edgeElement.getEdgeEnd();
        }
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ORIENTED_EDGE;
    }
}
