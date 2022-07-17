package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StepVector implements StepShapes{

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    protected StepShapes orientation;
    protected Double length;

    public StepVector(String name, StepShapes orientation, Double length) {
        this.name = name;
        this.orientation = orientation;
        this.length = length;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VECTOR;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>();
        treeItem.getChildren().add(orientation.getTreeItem());
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.VECTOR+ " " + name;
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }
}
