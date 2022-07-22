package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeLoop extends Loop {

    Set<Edge> orientedEdges;

    public EdgeLoop(String name, Set<Edge> orientedEdges,int lineNumber) {
        super(name,lineNumber,AP242Code.EDGE_LOOP);
        this.orientedEdges = orientedEdges;
    }

    public Set<Edge> getOrientedEdges() {
        return Set.copyOf(orientedEdges);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_LOOP;
    }

    @Override
    public String toString() {
        return AP242Code.EDGE_LOOP + " " + name;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        return new TreeItem<>(this);
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
