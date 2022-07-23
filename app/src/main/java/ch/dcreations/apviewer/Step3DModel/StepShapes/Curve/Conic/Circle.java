package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Conic;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;

public class Circle extends Conic{

    double radius;

    public Circle(String name, Axis2Placement3D position, double radius, int fileLineNumber, AP242Code ap242Code) {
        super(name, position, fileLineNumber, ap242Code);
        this.radius = radius;
    }

    public Circle(String name, Axis2Placement3D position,double radius, int fileLineNumber) {
        this(name, position,radius, fileLineNumber,AP242Code.CIRCLE);
    }
}
