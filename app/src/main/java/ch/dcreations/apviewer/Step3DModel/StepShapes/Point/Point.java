package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;


public abstract class Point extends StepShapes {


    public Point(String name,int lineNumber,AP242Code ap242Code) {
        super(ap242Code,name,lineNumber);
    }
    public Point(String name,int lineNumber) {
        this(name,lineNumber,AP242Code.POINT);
    }

    public abstract <T> T getPoint();


}
