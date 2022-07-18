package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Axis2Placement3D implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    protected StepShapes location;// Cartesian
    protected StepShapes axis ; // Direction
    protected StepShapes direction ; // Direction

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

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        return new TreeItem<>(this);
    }

    @Override
    public String toString() {
        return AP242Code.AXIS2_PLACEMENT_3D + " "+ name;
    }
    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }


    @Override
    public Shape3D getShape() {
        return null;
    }

}
