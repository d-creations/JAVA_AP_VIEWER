package ch.dcreations.apviewer.Step3DModel.StepShapes;

public class Axis2Placement3D implements StepShapes {
    String name;
    StepShapes location;// Cartesian
    StepShapes axis ; // Direction
    StepShapes direction ; // Direction

    public Axis2Placement3D(String name, StepShapes location, StepShapes axis, StepShapes direction) {
        this.name = name;
        this.location = location;
        this.axis = axis;
        this.direction = direction;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.AXIS2_PLACEMENT_3D;
    }
}
