package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Curve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.IncrementalPointsD;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;
import javafx.scene.control.TreeItem;

import java.util.*;


/**
 * Ecken Kante
 */
public class EdgeCurve extends Edge {

    protected List<IncrementalPointsD> edgeDrawingPoints = new ArrayList<IncrementalPointsD>();
    protected Curve edgeGeometrie; //vertex
    protected Boolean sameSense;//vertex

    public EdgeCurve(String name, Vertex edgeStart, Vertex edgeEnd, Curve edgeGeometrie, Boolean sameSense,int lineNumber) {
        super(name,edgeStart,edgeEnd,lineNumber,AP242Code.EDGE_CURVE);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }
    public EdgeCurve(String name, VertexPoint edgeStart, VertexPoint edgeEnd, Curve edgeGeometrie, Boolean sameSense,int lineNumber) {
        super(name,edgeStart,edgeEnd,lineNumber,AP242Code.EDGE_CURVE);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
        calculateEdgeDrawingPoints(edgeStart,edgeEnd);
    }

    private void calculateEdgeDrawingPoints(VertexPoint start,VertexPoint end){
        edgeDrawingPoints = edgeGeometrie.getEdgeDrawingPoints(start,end);
        return;
    }


    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(edgeStart.getTreeItem());
        treeItem.getChildren().add(edgeEnd.getTreeItem());
        return treeItem;
    }

    public List<IncrementalPointsD> getEdgeDrawingPoints() {
        return Collections.unmodifiableList(edgeDrawingPoints);
    }
}
