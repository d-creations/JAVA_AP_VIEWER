package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public abstract class Point implements StepShapes {

    protected String name;

    public Point(String name) {
        this.name = name;
    }

    public abstract <T> T getPoint();

    @Override
    public AP242Code getTyp() {
        return AP242Code.POINT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.POINT.toString() + "name";
    }
}
