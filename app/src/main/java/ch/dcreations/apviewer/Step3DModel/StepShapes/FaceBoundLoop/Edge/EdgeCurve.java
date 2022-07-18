package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Curve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * Ecken Kante
 */
public class EdgeCurve extends Edge implements StepShapes {

    protected Curve edgeGeometrie; //vertex
    protected Boolean sameSense;//vertex

    public EdgeCurve(String name, Vertex edgeStart, Vertex edgeEnd, Curve edgeGeometrie, Boolean sameSense) {
        super(name,edgeStart,edgeEnd);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }
    public EdgeCurve(String name, VertexPoint edgeStart, VertexPoint edgeEnd, Curve edgeGeometrie, Boolean sameSense) {
        super(name,edgeStart,edgeEnd);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_CURVE;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(edgeStart.getTreeItem());
        treeItem.getChildren().add(edgeEnd.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.EDGE_CURVE + " " + name;
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
