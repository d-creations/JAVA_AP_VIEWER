package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductDefinition implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String id;
    protected String name;
    protected String description;
    protected StepShapes productDefinitionFormation;
    protected StepShapes product;

    public ProductDefinition(String name, String description, StepShapes productDefinitionFormation,StepShapes product) {
        this.name = name;
        this.description = description;
        this.productDefinitionFormation = productDefinitionFormation;
        this.product = product;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(productDefinitionFormation.getTreeItem());
        treeItem.getChildren().add(product.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.PRODUCT_DEFINITION + " " + name;
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
