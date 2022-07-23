package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public abstract class Vertex extends StepShapes {


    public Vertex(String name,int lineNumber,AP242Code ap242Code) {
        super(ap242Code,name,lineNumber);
    }
    public Vertex(String name,int lineNumber) {
        this(name,lineNumber,AP242Code.VERTEX);
    }

    public abstract <T> T ifExistGivePoint();




}
