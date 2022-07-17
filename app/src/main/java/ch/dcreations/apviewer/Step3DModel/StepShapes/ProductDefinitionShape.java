package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductDefinitionShape implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();


    protected String name ;
    protected String description;
    protected StepShapes definition;

    public ProductDefinitionShape(String name, String description, StepShapes definition) {
        this.name = name;
        this.description = description;
        this.definition = definition;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION_SHAPE;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(definition.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.PRODUCT_DEFINITION_SHAPE + " " + name;
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
