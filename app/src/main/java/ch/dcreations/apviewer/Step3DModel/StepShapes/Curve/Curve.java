package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;


public class Curve extends StepShapes {

    public Curve(String name, int fileLineNumber) {
        this(name, fileLineNumber,AP242Code.CURVE);
    }

    protected Curve(String name, int fileLineNumber,AP242Code ap242Code) {
        super(ap242Code, name, fileLineNumber);
    }


}
