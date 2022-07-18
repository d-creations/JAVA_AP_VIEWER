package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ShapeDefinitionRepesentation implements StepShapes{

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected ProductDefinitionShape PRODUCT_DEFINITION_SHAPE;
    protected AdvancedBrepShapeRepresentation ADVANCED_BREP_SHAPE_REPRESENTATION;

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
        return AP242Code.SHAPE_DEFINITION_REPRESENTATION + " ";
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
