package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Axis2Placement3D extends StepShapes {

    protected CartesianPoint location;// Cartesian
    protected Direction axis ; // Direction
    protected Direction direction ; // Direction

    public Axis2Placement3D(String name, CartesianPoint location, Direction axis, Direction direction,int lineNumber) {
        super(AP242Code.AXIS2_PLACEMENT_3D,name,lineNumber);
        this.location = location;
        this.axis = axis;
        this.direction = direction;
    }

    public CartesianPoint getLocation() {
        return location;
    }

    public Direction getAxis() {
        return axis;
    }

    public Direction getDirection() {
        return direction;
    }
}
