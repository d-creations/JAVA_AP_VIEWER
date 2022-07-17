package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class ProductDefinition implements StepShapes {

    String id;
    String name;
    String description;
    StepShapes productDefinitionFormation;
    StepShapes product;

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
        return AP242Code.PRODUCT_DEFINITION.toString() + "name";
    }
}
