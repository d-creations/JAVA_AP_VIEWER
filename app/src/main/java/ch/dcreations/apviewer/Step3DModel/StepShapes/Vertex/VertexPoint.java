package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VertexPoint extends Vertex {

    CartesianPoint point;

    public VertexPoint(String name, CartesianPoint point,int lineNumber) {
        super(name,lineNumber,AP242Code.VERTEX_POINT);
        this.point = point;
    }


    @Override
    public CartesianPoint ifExistGivePoint() {
        return this.point;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(point.getTreeItem());
        return treeItem;
    }
}
