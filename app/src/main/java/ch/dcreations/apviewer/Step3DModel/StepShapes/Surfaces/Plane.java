package ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces;


import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;


public class Plane extends ElementarySurface {


    public Plane(String name, Axis2Placement3D position,int lineNumber) {
        super(name,position,lineNumber, AP242Code.PLANE);
    }

}
