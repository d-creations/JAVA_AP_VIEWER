package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Vertex implements StepShapes {
    protected String name;
    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();


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
        return AP242Code.VERTEX + " " + name;
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }

    @Override
    public Shape3D getShape() {
        return null;
    }



}
