package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

public class StepVector implements StepShapes{

    String name;
    StepShapes orientation;
    Double length;

    public StepVector(String name, StepShapes orientation, Double length) {
        this.name = name;
        this.orientation = orientation;
        this.length = length;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VECTOR;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>();
        treeItem.getChildren().add(orientation.getTreeItem());
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.VECTOR.toString() + "name";
    }
}
