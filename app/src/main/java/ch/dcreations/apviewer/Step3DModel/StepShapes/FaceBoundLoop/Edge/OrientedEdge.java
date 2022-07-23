package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import javafx.scene.control.TreeItem;


public class OrientedEdge extends Edge {

    protected Edge edgeElement;
    protected Boolean orientation;

    public OrientedEdge(String name, Vertex edgeStart, Vertex edgeEnd, Edge edgeElement, Boolean orientation,int lineNumber) {
        super(name,edgeElement.getEdgeStart(),edgeElement.getEdgeEnd(),lineNumber,AP242Code.ORIENTED_EDGE);
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
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(edgeElement.getTreeItem());
        return treeItem;
    }
}
