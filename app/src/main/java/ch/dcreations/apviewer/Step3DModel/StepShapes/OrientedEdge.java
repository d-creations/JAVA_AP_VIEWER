package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class OrientedEdge implements StepShapes {
    String name;
    String edgeStart;
    String edgeEnd;
    StepShapes edgeElement;
    Boolean orientation;

    public OrientedEdge(String name, String edgeStart, String edgeEnd, StepShapes edgeElement, Boolean orientation) {
        this.name = name;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
        this.edgeElement = edgeElement;
        this.orientation = orientation;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ORIENTED_EDGE;
    }
}
