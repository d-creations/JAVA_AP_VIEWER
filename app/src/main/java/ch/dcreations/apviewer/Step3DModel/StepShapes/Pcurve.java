package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class Pcurve implements StepShapes {
    String name;
    StepShapes basis;
    StepShapes curve;

    public Pcurve(String name, StepShapes basis, StepShapes curve) {
        this.name = name;
        this.basis = basis;
        this.curve = curve;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PCURVE;
    }
}
