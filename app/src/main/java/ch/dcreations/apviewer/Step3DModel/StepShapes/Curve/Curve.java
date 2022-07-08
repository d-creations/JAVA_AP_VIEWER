package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class Curve implements StepShapes {
    @Override
    public AP242Code getTyp() {
        return AP242Code.CURVE;
    }
}
