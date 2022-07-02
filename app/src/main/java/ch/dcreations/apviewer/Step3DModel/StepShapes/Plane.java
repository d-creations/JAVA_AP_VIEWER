package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class Plane implements StepShapes {
    String name;
    StepShapes position;

    public Plane(String name, StepShapes position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PLANE;
    }
}
