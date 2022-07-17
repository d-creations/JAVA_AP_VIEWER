package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public abstract class Vertex implements StepShapes {

    String name;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract <T> T ifExistGivePoint();

    @Override
    public AP242Code getTyp() {
        return AP242Code.VERTEX;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>();
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.VERTEX.toString() + "name";
    }
}
