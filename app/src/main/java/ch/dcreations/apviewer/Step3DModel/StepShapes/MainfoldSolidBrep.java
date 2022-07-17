package ch.dcreations.apviewer.Step3DModel.StepShapes;


import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class MainfoldSolidBrep implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    protected StepShapes shapeData;
    public MainfoldSolidBrep(String name, StepShapes stepShapes) {
        this.name = name;
        this.shapeData = stepShapes;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.MANIFOLD_SOLID_BREP;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(shapeData.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.MANIFOLD_SOLID_BREP +" " +  name;
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
