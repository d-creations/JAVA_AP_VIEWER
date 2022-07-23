package ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;

public class SphericalSurface extends ElementarySurface{

    protected double radius;

    public SphericalSurface(String name, Axis2Placement3D position,double radius, int lineNumber) {
        super(name, position, lineNumber, AP242Code.SPHERICAL_SURFACE);
        this.radius = radius;
        System.out.println("Radius " + this.radius);
    }

    public double getRadius() {
        return radius;
    }
}
