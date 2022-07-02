package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class VertexPoint implements StepShapes {
    String name;
    StepShapes point;

    public VertexPoint(String name, StepShapes point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VERTEX_POINT;
    }
}
