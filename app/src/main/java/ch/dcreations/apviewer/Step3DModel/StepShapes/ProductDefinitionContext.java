package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class ProductDefinitionContext implements StepShapes {
    String name;
    StepShapes calculationDecoding;
    String disciplineType;

    public ProductDefinitionContext(String name, StepShapes calculationDecoding, String disciplineType) {
        this.name = name;
        this.calculationDecoding = calculationDecoding;
        this.disciplineType = disciplineType;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION_CONTEXT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(calculationDecoding.getTreeItem());
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.PRODUCT_DEFINITION_CONTEXT.toString() + "name";
    }


}
