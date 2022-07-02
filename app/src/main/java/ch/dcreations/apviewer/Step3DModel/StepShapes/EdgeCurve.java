package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class EdgeCurve implements StepShapes {
    String name; //vertex
    StepShapes edgeStart;//vertex
    StepShapes edgeEnd; //vertex
    StepShapes edgeGeometrie; //vertex
    Boolean sameSense;//vertex

    public EdgeCurve(String name, StepShapes edgeStart, StepShapes edgeEnd, StepShapes edgeGeometrie, Boolean sameSense) {
        this.name = name;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_CURVE;
    }
}
