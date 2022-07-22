package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;


public class Loop extends StepShapes {
    protected String name;

    public Loop(String name,int lineNumber,AP242Code ap242Code) {
        super(ap242Code,name,lineNumber);
    }
    public Loop(String name,int lineNumber) {
        this(name,lineNumber,AP242Code.LOOP);
    }
}
