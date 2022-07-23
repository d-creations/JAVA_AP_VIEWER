package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Axis2Placement3D extends StepShapes {

    protected StepShapes location;// Cartesian
    protected StepShapes axis ; // Direction
    protected StepShapes direction ; // Direction

    public Axis2Placement3D(String name, StepShapes location, StepShapes axis, StepShapes direction,int lineNumber) {
        super(AP242Code.AXIS2_PLACEMENT_3D,name,lineNumber);
        this.location = location;
        this.axis = axis;
        this.direction = direction;
    }
}
