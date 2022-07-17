package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Point implements StepShapes {

    protected String name;
    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();


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
        return new TreeItem<>(this);
    }

    @Override
    public String toString() {
        return AP242Code.POINT + " " + name;
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }
}
