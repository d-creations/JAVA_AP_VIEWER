package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class Point implements StepShapes {

    protected String name;

    public Point(String name) {
        this.name = name;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.POINT;
    }
}
