package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Shape3D;

import java.util.List;
import java.util.Map;

public interface StepShapes {
    AP242Code getTyp();

    TreeItem<StepShapes> getTreeItem();

    List<Map<String,String>> getPreferencesList();
    boolean setPreference(Map<String,String> preference);

    Shape3D getShape();
}
