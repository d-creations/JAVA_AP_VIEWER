package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Map;

public class VertexPoint extends Vertex implements StepShapes {

    Point point;

    public VertexPoint(String name, Point point) {
        super(name);
        this.point = point;
    }


    public VertexPoint(String name, CartesianPoint point) {
        super(name);
        this.point = point;
    }


    @Override
    public Point ifExistGivePoint() {
        return this.point;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VERTEX_POINT;
    }
}
