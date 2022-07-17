package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class Loop implements StepShapes {
    String name;

    public Loop(String name) {
        this.name = name;
    }

    @Override
    public AP242Code getTyp() {

        return AP242Code.LOOP;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        return new TreeItem<StepShapes>(this);
    }


    @Override
    public String toString() {
        return AP242Code.LOOP.toString() + "name";
    }
}
