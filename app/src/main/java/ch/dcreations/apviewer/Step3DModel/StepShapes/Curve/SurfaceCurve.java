package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.*;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Conic.Circle;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;
import javafx.scene.control.TreeItem;

import java.util.List;
import java.util.Set;

public class SurfaceCurve extends Curve {
    protected Curve curve;
    protected Set<StepShapes> items;
    protected PreferredSurfaceCurveRepresentation representation;

    public SurfaceCurve(String name, Curve curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation, AP242Code ap242Code, int lineNumber) {
        super(name, lineNumber, ap242Code);
        this.curve = curve;
        this.items = items;
        this.representation = representation;
    }

    @Override
    public List<IncrementalPointsD> getEdgeDrawingPoints(VertexPoint start, VertexPoint end) {
        switch (curve.getTyp()){
            case LINE -> calculateLineGeometrie(start,end);
            case CIRCLE -> calculateCurveGeometrie(start,end);
        }
        return super.getEdgeDrawingPoints(start, end);
    }


    private void calculateLineGeometrie(VertexPoint start, VertexPoint end){
        System.out.println("Line Geometrie");
        //@todo this.edgeDrawingPoints.add(new IncrementalPointsD();
    }
    private void calculateCurveGeometrie(VertexPoint start, VertexPoint end){
        System.out.println("circle geometrie");
        Circle circle = (Circle) curve;
        Axis2Placement3D position =  circle.getPosition();
        CartesianPoint middlePoint = position.getLocation();
        Direction axis = position.getAxis();
        this.edgeDrawingPoints.add(new IncrementalPointsD(0,0,0));
    }

    public SurfaceCurve(String name, Curve curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation, int lineNumber) {
        this(name, curve, items, representation, AP242Code.SURFACE_CURVE, lineNumber);
    }
    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(curve.getTreeItem());
        for(StepShapes item : items){
            treeItem.getChildren().add(item.getTreeItem());
        }
        return treeItem;
    }
}
