package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrientedEdge extends Edge implements StepShapes {

    protected Edge edgeElement;
    protected Boolean orientation;

    public OrientedEdge(String name, Vertex edgeStart, Vertex edgeEnd, Edge edgeElement, Boolean orientation) {
        super(name,edgeElement.getEdgeStart(),edgeElement.getEdgeEnd());
        this.edgeElement = edgeElement;
        this.orientation = orientation;
        calculateEdge();
    }

    private void calculateEdge() {
        if(edgeStart.getName().equals("*")) {
            edgeStart = edgeElement.getEdgeStart();
        }
        if(edgeEnd.getName().equals("*")){
            edgeEnd = edgeElement.getEdgeEnd();
        }
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ORIENTED_EDGE;
    }

    @Override
    public String toString() {
        return AP242Code.ORIENTED_EDGE + " " + name;
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
