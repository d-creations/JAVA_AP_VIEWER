package ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class Surface implements StepShapes {

    String name;

    public Surface(String name) {
        this.name = name;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.SURFACE;
    }
}
