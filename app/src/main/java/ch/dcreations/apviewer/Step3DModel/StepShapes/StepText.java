package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

public class StepText implements StepShapes{

    String name ;

    public StepText(String name) {
        this.name = name;
    }

    @Override
    public AP242Code getTyp() {
        return null;
    }


    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        return treeItem;
    }

    @Override
    public String toString() {
        return name;
    }
}
