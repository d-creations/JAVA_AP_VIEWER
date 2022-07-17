package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class Curve implements StepShapes {
    @Override
    public AP242Code getTyp() {
        return AP242Code.CURVE;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.CURVE.toString() + "name";
    }
}
