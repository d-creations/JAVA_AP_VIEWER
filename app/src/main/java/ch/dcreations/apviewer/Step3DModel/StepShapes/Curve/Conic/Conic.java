package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Conic;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Curve;

public class Conic extends Curve {

    protected Axis2Placement3D position;

    protected Conic(String name,Axis2Placement3D position, int fileLineNumber, AP242Code ap242Code) {
        super(name, fileLineNumber, ap242Code);
        this.position = position;
    }

    protected Conic(String name, Axis2Placement3D position,int fileLineNumber) {
        this(name,position, fileLineNumber, AP242Code.CONIC);
    }
}
