package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.*;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Conic.Circle;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
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

    public SurfaceCurve(String name, Curve curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation, int lineNumber) {
        this(name, curve, items, representation, AP242Code.SURFACE_CURVE, lineNumber);
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
        try {
            Circle circle = (Circle) curve;
            Axis2Placement3D position = circle.getPosition();
            CartesianPoint middlePoint = position.getLocation();
            Direction axis = position.getAxis();
            Direction firstDirectionE = position.getDirection();
            // Kreuzprodukt
            List<Double> secondDirectionList = new ArrayList<>();
            secondDirectionList.add(axis.getDirectionRatios().get(1) * firstDirectionE.getDirectionRatios().get(2) - axis.getDirectionRatios().get(2) * firstDirectionE.getDirectionRatios().get(1)); // add X
            secondDirectionList.add(axis.getDirectionRatios().get(2) * firstDirectionE.getDirectionRatios().get(0) - axis.getDirectionRatios().get(0) * firstDirectionE.getDirectionRatios().get(2)); // add Y
            secondDirectionList.add(axis.getDirectionRatios().get(0) * firstDirectionE.getDirectionRatios().get(1) - axis.getDirectionRatios().get(1) * firstDirectionE.getDirectionRatios().get(0)); // add Z
            Direction secondDirectionE = new Direction("", secondDirectionList, 0);

            //Tranlatation Start Point And Endpoint to 0,0,0 Middlepoint
            double startXBasisN = 0, startYBasisN = 0, startZBasisN = 0;
            double endXBasisN = 0, endYBasisN = 0, endZBasisN = 0;
            startXBasisN = ((CartesianPoint) start.ifExistGivePoint().getPoint()).getPoint().get(CartasianAxisE.X) - middlePoint.getPoint().get(CartasianAxisE.X);
            startYBasisN = ((CartesianPoint) start.ifExistGivePoint().getPoint()).getPoint().get(CartasianAxisE.Y) - middlePoint.getPoint().get(CartasianAxisE.Y);
            startZBasisN = ((CartesianPoint) start.ifExistGivePoint().getPoint()).getPoint().get(CartasianAxisE.Z) - middlePoint.getPoint().get(CartasianAxisE.Z);
            endXBasisN = ((CartesianPoint) end.ifExistGivePoint().getPoint()).getPoint().get(CartasianAxisE.X) - middlePoint.getPoint().get(CartasianAxisE.X);
            endYBasisN = ((CartesianPoint) end.ifExistGivePoint().getPoint()).getPoint().get(CartasianAxisE.Y) - middlePoint.getPoint().get(CartasianAxisE.Y);
            endZBasisN = ((CartesianPoint) end.ifExistGivePoint().getPoint()).getPoint().get(CartasianAxisE.Z) - middlePoint.getPoint().get(CartasianAxisE.Z);
            // move in first dirextion = x   second Direceten = y  trith direction = z   as symbol e
            double x = 0, y = 0, z = 0;


            //Basiswechsel mit dem Einheits Normalvektor
            double xBasisN = x * firstDirectionE.getDirectionRatios().get(0) + y * secondDirectionE.getDirectionRatios().get(0) + z * axis.getDirectionRatios().get(0);
            double yBasisN = x * firstDirectionE.getDirectionRatios().get(1) + y * secondDirectionE.getDirectionRatios().get(1) + z * axis.getDirectionRatios().get(1);
            ;
            double zBasisN = x * firstDirectionE.getDirectionRatios().get(2) + y * secondDirectionE.getDirectionRatios().get(2) + z * axis.getDirectionRatios().get(2);
            ;
            // Transformation to MiddlePoint
            xBasisN += middlePoint.getPoint().get(CartasianAxisE.X);
            yBasisN += middlePoint.getPoint().get(CartasianAxisE.Y);
            zBasisN += middlePoint.getPoint().get(CartasianAxisE.Z);
            this.edgeDrawingPoints.add(new IncrementalPointsD(xBasisN, yBasisN, zBasisN));
        }catch (Exception e){
            System.out.println("Points where not defined ");
        }
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
