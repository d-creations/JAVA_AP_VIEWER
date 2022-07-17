package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VertexPoint extends Vertex implements StepShapes {

    Point point;

    public VertexPoint(String name, Point point) {
        super(name);
        this.point = point;
    }


    public VertexPoint(String name, CartesianPoint point) {
        super(name);
        this.point = point;
    }


    @Override
    public Point ifExistGivePoint() {
        return this.point;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VERTEX_POINT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(point.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.VERTEX_POINT + " " + name;
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
