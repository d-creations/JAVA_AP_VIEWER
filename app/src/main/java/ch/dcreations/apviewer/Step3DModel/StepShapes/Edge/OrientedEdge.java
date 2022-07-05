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
        if(edgeStart.getName()=="*"){
            edgeStart = edgeElement.getEdgeStart();
        }
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ORIENTED_EDGE;
    }
}
