package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.*;

public class DefinitionalRepresentation implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    protected Set<StepShapes> items;
    protected StepShapes representationContext;

    public DefinitionalRepresentation(String name, Set<StepShapes> items, StepShapes representationContext) {
        this.name = name;
        this.items = items;
        this.representationContext = representationContext;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.DEFINITIONAL_REPRESENTATION;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(StepShapes item : items){
            treeItem.getChildren().add(item.getTreeItem());
        }
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.DEFINITIONAL_REPRESENTATION + " " +name;
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
