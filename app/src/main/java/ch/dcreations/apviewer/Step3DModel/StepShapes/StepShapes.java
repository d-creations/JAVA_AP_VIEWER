package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;

public interface StepShapes {
    AP242Code getTyp();

    TreeItem<StepShapes> getTreeItem();
}
