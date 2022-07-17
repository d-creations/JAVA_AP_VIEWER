package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;


public class MainfoldSolidBrep implements StepShapes {

    String name;
    StepShapes shapeData;
    public MainfoldSolidBrep(String name, StepShapes stepShapes) {
        this.name = name;
        this.shapeData = stepShapes;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.MANIFOLD_SOLID_BREP;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(shapeData.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.MANIFOLD_SOLID_BREP.toString() + "name";
    }

}
