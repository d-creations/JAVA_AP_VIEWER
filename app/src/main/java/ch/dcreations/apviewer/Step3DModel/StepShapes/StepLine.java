package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class StepLine implements StepShapes {
    String name;
    StepShapes coordinateSystem;
    StepShapes vector;

    public StepLine(String name, StepShapes coordinateSystem, StepShapes vector) {
        this.name = name;
        this.coordinateSystem = coordinateSystem;
        this.vector = vector;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.LINE;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(coordinateSystem.getTreeItem());
        treeItem.getChildren().add(vector.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.LINE.toString() + "name";
    }
}
