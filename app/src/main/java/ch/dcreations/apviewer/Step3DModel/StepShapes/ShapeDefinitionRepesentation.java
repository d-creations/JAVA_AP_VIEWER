package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

public class ShapeDefinitionRepesentation implements StepShapes{

    ProductDefinitionShape PRODUCT_DEFINITION_SHAPE;
    AdvancedBrepShapeRepresentation ADVANCED_BREP_SHAPE_REPRESENTATION;

    public ShapeDefinitionRepesentation(StepShapes productDefinitionShape, StepShapes advancedBrepShapeRepresentation) {
        this.ADVANCED_BREP_SHAPE_REPRESENTATION = (AdvancedBrepShapeRepresentation) advancedBrepShapeRepresentation;
        this.PRODUCT_DEFINITION_SHAPE = (ProductDefinitionShape) productDefinitionShape;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.SHAPE_DEFINITION_REPRESENTATION;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(PRODUCT_DEFINITION_SHAPE.getTreeItem());
        treeItem.getChildren().add(ADVANCED_BREP_SHAPE_REPRESENTATION.getTreeItem());
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.SHAPE_DEFINITION_REPRESENTATION.toString() + "name";
    }

}
