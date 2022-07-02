package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class StepLine implements StepShapes {
    String name;
    StepShapes coordinateSystem;
    StepShapes vector;

    public StepLine(String name, StepShapes coordinateSystem, StepShapes vector) {
        this.name = name;
        this.coordinateSystem = coordinateSystem;
        this.vector = vector;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.LINE;
    }
}
