package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.*;

public class Product implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String id;
    protected String name;
    protected String descrition;
    protected Set<StepShapes> frameReferences;

    public Product(String id, String name, String description, Set<StepShapes> frameReferences) {
        this.id = id;
        this.name = name;
        this.descrition = description;
        this.frameReferences = frameReferences;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(StepShapes item : frameReferences){
            treeItem.getChildren().add(item.getTreeItem());
        }
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.PRODUCT + " " +  name;
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
