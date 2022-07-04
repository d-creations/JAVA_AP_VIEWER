package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class VertexPoint extends Vertex implements StepShapes {

    StepShapes point;

    public VertexPoint(String name, StepShapes point) {
        super(name);
        this.point = point;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VERTEX_POINT;
    }
}
