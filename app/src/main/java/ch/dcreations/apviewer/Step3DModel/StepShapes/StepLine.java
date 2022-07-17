package ch.dcreations.apviewer.Step3DModel.StepShapes;


import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StepLine implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    protected StepShapes coordinateSystem;
    protected StepShapes vector;

    public StepLine(String name, StepShapes coordinateSystem, StepShapes vector) {
        this.name = name;
        this.coordinateSystem = coordinateSystem;
        this.vector = vector;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.LINE;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(coordinateSystem.getTreeItem());
        treeItem.getChildren().add(vector.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.LINE + " " + name;
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
