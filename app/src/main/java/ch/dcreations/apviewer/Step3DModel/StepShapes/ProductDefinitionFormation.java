package ch.dcreations.apviewer.Step3DModel.StepShapes;


import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductDefinitionFormation implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String id;
    protected String description;
    protected StepShapes productReference;

    public ProductDefinitionFormation(String id, String description, StepShapes productReference) {
        this.id = id;
        this.description = description;
        this.productReference = productReference;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION_FORMATION;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(productReference.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.PRODUCT_DEFINITION_FORMATION + " ";
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
