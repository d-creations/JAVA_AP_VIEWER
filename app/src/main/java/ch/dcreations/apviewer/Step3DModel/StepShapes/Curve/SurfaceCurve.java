package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.*;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Conic.Circle;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;
import javafx.scene.control.TreeItem;

import java.util.List;
import java.util.Set;

import static ch.dcreations.apviewer.Step3DModel.Config.StepConfig.CIRCALRESOLUTION;

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
        switch (curve.getTyp()) {
            case LINE -> calculateLineGeometrie(start, end);
            case CIRCLE -> calculateCurveGeometrie(start, end);
        }
        return super.getEdgeDrawingPoints(start, end);
    }


    private void calculateLineGeometrie(VertexPoint start, VertexPoint end) {
        System.out.println("Line Geometrie");
        this.edgeDrawingPoints.add(new IncrementalPointsD(end.ifExistGivePoint().getPoint().get(CartasianAxisE.X), end.ifExistGivePoint().getPoint().get(CartasianAxisE.Y), end.ifExistGivePoint().getPoint().get(CartasianAxisE.Z)));

    }

    private void calculateCurveGeometrie(VertexPoint start, VertexPoint end) {
        System.out.println("circle geometrie");
        try {
            Circle circle = (Circle) curve;
            Axis2Placement3D position = circle.getPosition();
            CartesianPoint middlePoint = position.getLocation();
            Direction axis = position.getAxis();
            Direction firstDirectionE = position.getFirstDirection();
            Direction secondDirectionE = position.getSecondDirection();
            //Basiswechsel   Translation  Start Point And Endpoint to 0,0,0 Midpoint
            double endXBasisN ,endYBasisN, endZBasisN ;
             endXBasisN = ( end.ifExistGivePoint()).getPoint().get(CartasianAxisE.X) - middlePoint.getPoint().get(CartasianAxisE.X);
            endYBasisN = ( end.ifExistGivePoint()).getPoint().get(CartasianAxisE.Y) - middlePoint.getPoint().get(CartasianAxisE.Y);
            endZBasisN = (end.ifExistGivePoint()).getPoint().get(CartasianAxisE.Z) - middlePoint.getPoint().get(CartasianAxisE.Z);
            //drawing the midpoint for the Triangle
            this.edgeDrawingPoints.add(new IncrementalPointsD(middlePoint.getPoint().get(CartasianAxisE.X), middlePoint.getPoint().get(CartasianAxisE.Y), middlePoint.getPoint().get(CartasianAxisE.Z)));

            // move in   1  direction = x   2 Direction = y  3 direction = z   as symbol e
            int i = 0;
            double DistanceToEndPoint = 0;
            while (i<360 && ((DistanceToEndPoint > (2*CIRCALRESOLUTION) && i > (5*CIRCALRESOLUTION))|| i <  50*CIRCALRESOLUTION)) {
                double x = circle.getRadius() * (-Math.sin(Math.toRadians(i)));
                double y = circle.getRadius() * (Math.cos(Math.toRadians(i)));
                double z = 0;
                //Basiswechsel Translation mit dem Einheitsnormalvektor
                double yBasisN = y * firstDirectionE.getDirectionRatios().get(1) + x * secondDirectionE.getDirectionRatios().get(1) + z * axis.getDirectionRatios().get(1);
                double xBasisN = y * firstDirectionE.getDirectionRatios().get(0) + x * secondDirectionE.getDirectionRatios().get(0) + z * axis.getDirectionRatios().get(0);
                double zBasisN = y * firstDirectionE.getDirectionRatios().get(2) + x * secondDirectionE.getDirectionRatios().get(2) + z * axis.getDirectionRatios().get(2);
                ;
                // Calculate Distance the nuew Point Distance to Endpoint
                DistanceToEndPoint = Math.sqrt((-xBasisN + endXBasisN) * (-xBasisN + endXBasisN) + (-yBasisN + endYBasisN) * (-yBasisN + endYBasisN) + (-zBasisN + endZBasisN) * (-zBasisN + endZBasisN));

                xBasisN += middlePoint.getPoint().get(CartasianAxisE.X);
                yBasisN += middlePoint.getPoint().get(CartasianAxisE.Y);
                zBasisN += middlePoint.getPoint().get(CartasianAxisE.Z);
                this.edgeDrawingPoints.add(new IncrementalPointsD(xBasisN, yBasisN, zBasisN));

                // Calculate Distance the nuew Point Distance to Endpoint
                DistanceToEndPoint = Math.sqrt((-xBasisN + endXBasisN) * (-xBasisN + endXBasisN) + (-yBasisN + endYBasisN) * (-yBasisN + endYBasisN) + (-zBasisN + endZBasisN) * (-zBasisN + endZBasisN));
                i += CIRCALRESOLUTION;
            }
        } catch (Exception e) {
            System.out.println(" Could not draw the Points ");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(curve.getTreeItem());
        for (StepShapes item : items) {
            treeItem.getChildren().add(item.getTreeItem());
        }
        return treeItem;
    }
}
