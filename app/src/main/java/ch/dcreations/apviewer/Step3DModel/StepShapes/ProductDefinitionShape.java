package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

public class ProductDefinitionShape implements StepShapes {
    String name ;
    String description;
    StepShapes definition;

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
        return AP242Code.PRODUCT_DEFINITION_SHAPE.toString() + "name";
    }

}
