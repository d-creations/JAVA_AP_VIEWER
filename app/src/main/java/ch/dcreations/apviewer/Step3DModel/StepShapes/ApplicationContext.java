package ch.dcreations.apviewer.Step3DModel.StepShapes;


import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ApplicationContext implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    public ApplicationContext(String name) {
        this.name = name;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.APPLICATION_CONTEXT;
    }
    @Override
    public TreeItem<StepShapes> getTreeItem() {
        return new TreeItem<>(this);
    }

    @Override
    public String toString() {
        return AP242Code.APPLICATION_CONTEXT + " " + name;
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
