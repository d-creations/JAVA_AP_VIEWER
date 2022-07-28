package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.Config.StepConfig;
import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.IncrementalPointsD;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.OrientedEdge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.CylindricalSurface;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.SphericalSurface;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;
import javafx.scene.control.TreeItem;

import java.util.*;

public class AdvancedFace extends FaceSurface {


    public AdvancedFace(String name, Set<FaceBound> setOfFaces, Surface faceGeometrie, Boolean sameSense,int lineNumber) {
        super(name, setOfFaces, faceGeometrie, sameSense,lineNumber,AP242Code.ADVANCED_FACE);
        Map<String,String> preferencesMap = new HashMap<>();
        preferencesMap.put("Same Sense",sameSense.toString());
        preferencesMapList.add(preferencesMap);
        switch (faceGeometrie.getTyp()){
            case PLANE -> renderPlan();
            case SPHERICAL_SURFACE ->renderSphericalSurface(((SphericalSurface) faceGeometrie).getRadius());
            case CYLINDRICAL_SURFACE -> {
                for (FaceBound faceB : getFaceBound()){
                    for (Edge edge : faceB.getEdgeLoop().getOrientedEdges()){
                        renderACylinder(((CylindricalSurface)faceGeometrie).getRadius(),edge.getStartX(), edge.getStartY(), edge.getStartZ(),edge.getEndX(), edge.getEndY(), edge.getEndZ());
                    }
                }
            }


        }
    }

    private void  renderACylinder(double radius,double startX,double startY,double startZ,double endX,double endY,double endZ){
        // Separate the Spherical in spherical layers Sektor    // h = höhe der Halbkugel  = a katete  r = hypotenuse
        int countTrianglePerLayer = StepConfig.COUNTTRIANGLEPERLAYER;
        double layerRadiusUP = radius;
        double layerRadiusDown = radius;
        double diffX = startX - endX;
        double diffY = startY - endY;
        double diffZ = startZ - endZ;
        double z1 = endZ;
        double z4 = endZ;
        double z2 = startZ;
        double z3 = startZ;
        int i = 0;
        CreateAZylinderWithTriangles(radius, countTrianglePerLayer, layerRadiusUP, layerRadiusDown, diffX, diffY, diffZ, z1, z4, z2, z3, i);

    }

    private void renderSphericalSurface(double radius) {

        // Separate the Spherical in spherical layers Sektor    // h = höhe der Halbkugel  = a katete  r = hypotenuse
        int countLayers = StepConfig.COUNTLAYERS; // Half Spherical needs to be uneven
        int countTrianglePerLayer = StepConfig.COUNTTRIANGLEPERLAYER;
        //for each Layer calculate circumference
        for(int k = 1 ; k > -2 ; k -= 2){
        for (int i = 0; i < countLayers; i++) {
            double hLayerUP = radius*Math.cos(Math.toRadians(90 / countLayers*i));
            double hLayerDOWN = radius*Math.cos(Math.toRadians(90 / countLayers*(i + 1)));
            double distanceFromSphericalTop = radius-hLayerUP;
            double aCatate = radius - distanceFromSphericalTop;
            double layerRadiusUP = Math.sqrt(radius * radius - aCatate * aCatate);
            double distanceFromSphericalTopDown = (radius-hLayerDOWN);
            double aCathetusADown = radius - distanceFromSphericalTopDown;
            double layerRadiusDown = Math.sqrt(radius * radius - aCathetusADown * aCathetusADown);
            double z1 = aCatate*k;
            double z4 = aCatate*k;
            double z2 = aCathetusADown*k;
            double z3 = aCathetusADown*k;
            CreateAZylinderWithTriangles(radius, countTrianglePerLayer, layerRadiusUP, layerRadiusDown, 0, 0, 0, z1, z4, z2, z3, i);
        }
    }
    }




    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(FaceBound faceBound : this.FaceBound){
            treeItem.getChildren().add(faceBound.getTreeItem());
        }
        treeItem.getChildren().add(faceGeometrie.getTreeItem());
        return treeItem;
    }

    public void renderPlan(){
        for (FaceBound face : getFaceBound()) {
            if (face.getEdgeLoop() != null) {
                List<OrientedEdge> tempAllEdges = new ArrayList<>(face.getEdgeLoop().getOrientedEdges());
                for (int i = 0; i < tempAllEdges.size(); i++) {
                    for (int y = 0;y<tempAllEdges.get(i).getEdgeElement().getEdgeDrawingPoints().size();y++) {
                        int z  = (y+1 >= tempAllEdges.get(i).getEdgeElement().getEdgeDrawingPoints().size()) ? 0 : y+1;
                        IncrementalPointsD incrementalPointsDStartEdgeStart = tempAllEdges.get(0).getEdgeElement().getEdgeDrawingPoints().get(0);
                        IncrementalPointsD incrementalPointsDStart = tempAllEdges.get(0).getEdgeElement().getEdgeDrawingPoints().get(z);
                        IncrementalPointsD incrementalPointsD = tempAllEdges.get(i).getEdgeElement().getEdgeDrawingPoints().get(y);
                        System.out.println(tempAllEdges.get(0).getEdgeElement().getTyp());
                        Double x1 = tempAllEdges.get(0).getStartX();
                        Double y1 = tempAllEdges.get(0).getStartY();
                        Double z1 = tempAllEdges.get(0).getStartZ();
                        if (y > 0) {
                             x1 = incrementalPointsDStartEdgeStart.x();
                             y1 = incrementalPointsDStartEdgeStart.y();
                             z1 = incrementalPointsDStartEdgeStart.z();
                        }
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1   -1
                        Double x2 =incrementalPointsDStart.x(); // tempAllEdges.get(0).getEndX();
                        Double y2 =incrementalPointsDStart.y(); //tempAllEdges.get(0).getEndY();
                        Double z2 = incrementalPointsDStart.z(); // tempAllEdges.get(0).getEndZ();
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2    -2
                        Double x3 = tempAllEdges.get(i).getStartX();
                        Double y3 = tempAllEdges.get(i).getStartY();
                        Double z3 = tempAllEdges.get(i).getStartZ();
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3, y3, z3));//p3      -END
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p4     -1
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//P5      -2
                        double x4 = incrementalPointsD.x();//tempAllEdges.get(i).getEndX();
                        double y4 = incrementalPointsD.y();//tempAllEdges.get(i).getEndY();
                        double z4 = incrementalPointsD.z();//tempAllEdges.get(i).getEndZ();
                        addTriangles(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
                        x1 = tempAllEdges.get(tempAllEdges.size() - 1).getStartX();
                        y1 = tempAllEdges.get(tempAllEdges.size() - 1).getStartY();
                        z1 = tempAllEdges.get(tempAllEdges.size() - 1).getStartZ();
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1   -1
                        x2 = tempAllEdges.get(tempAllEdges.size() - 1).getEndX();
                        y2 = tempAllEdges.get(tempAllEdges.size() - 1).getEndY();
                        z2 = tempAllEdges.get(tempAllEdges.size() - 1).getEndZ();
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2    -2
                        x3 = incrementalPointsD.x();//tempAllEdges.get(i).getEndX();
                        y3 = incrementalPointsD.y();//tempAllEdges.get(i).getEndY();
                        z3 = incrementalPointsD.z();//tempAllEdges.get(i).getEndZ();
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3, y3, z3));//p3      -END


                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p4     -1
                        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//P5      -2
                        x4 = tempAllEdges.get(i).getStartX();
                        y4 = tempAllEdges.get(i).getStartY();
                        z4 = tempAllEdges.get(i).getStartZ();
                        addTriangles(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
                        }
                    }
            }
        }
    }

    private void addTriangles(Double x1, Double y1, Double z1, Double x2, Double y2, Double z2, Double x3, Double y3, Double z3, Double x4, Double y4, Double z4) {
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x4,y4,z4));//P6      -START
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3,y3,z3));//p7     END
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x4,y4,z4));//p8     STAR
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1,y1,z1));//p9        -1
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3,y3,z3));//p10     END
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x4,y4,z4));//p11    sTART
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2,y2,z2));//p12  -2
    }

    private CartesianPoint getCartesianPoint(Double x, Double y, Double z){
        List<Double> directions = new ArrayList<>();
        directions.add(x);
        directions.add(y);
        directions.add(z);
        return new CartesianPoint("",directions,fileLineNumber);
    }


// DRAW A CYLINDER WITH TRIANGLES
    private void CreateAZylinderWithTriangles(double radius, int countTrianglePerLayer, double layerRadiusUP, double layerRadiusDown, double diffX, double diffY, double diffZ, double z1, double z4, double z2, double z3, int i) {
        for (int y = 0; y < countTrianglePerLayer; y++) {
            double layerCircumferenceSequenzUP = (2 * Math.PI * radius) / countTrianglePerLayer;////////////////A     D
            double layerCircumferenceSequenzDown = (2 * Math.PI * radius) / countTrianglePerLayer;///////// B   C

            double pointA = (layerCircumferenceSequenzUP / 2) * (i % 2) + y * layerCircumferenceSequenzUP;
            double pointD = (layerCircumferenceSequenzUP / 2) * (i % 2) + (y + 1) * layerCircumferenceSequenzUP;
            double pointB = -(layerCircumferenceSequenzDown / 2) * ((i + 1) % 2) + layerCircumferenceSequenzDown * y;
            double pointC = -(layerCircumferenceSequenzDown / 2) * ((i + 1) % 2) + layerCircumferenceSequenzDown * (y + 1);
            // Calculate Coordinates
            // Point A
            double angleBPointA = layerRadiusUP == 0 ? 0 : ((360 / (2 * Math.PI * layerRadiusUP)) * pointA);
            double angleBPointD = layerRadiusUP == 0 ? 0 : ((360 / (2 * Math.PI * layerRadiusUP)) * pointD);
            double angleBPointB = layerRadiusDown == 0 ? 0 : ((360 / (2 * Math.PI * layerRadiusDown)) * pointB);
            double angleBPointC = layerRadiusDown == 0 ? 0 : ((360 / (2 * Math.PI * layerRadiusDown)) * pointC);
            //Transformation X Y
            double x1 = layerRadiusUP * (-Math.sin(Math.toRadians(angleBPointA)));
            double y1 = layerRadiusUP * (Math.cos(Math.toRadians(angleBPointA)));
            double x4 = layerRadiusUP * (-Math.sin(Math.toRadians(angleBPointD)));
            double y4 = layerRadiusUP * (Math.cos(Math.toRadians(angleBPointD)));
            double x2 = layerRadiusDown * (-Math.sin(Math.toRadians(angleBPointB)));
            double y2 = layerRadiusDown * (Math.cos(Math.toRadians(angleBPointB)));
            double x3 = layerRadiusDown * (-Math.sin(Math.toRadians(angleBPointC)));
            double y3 = layerRadiusDown * (Math.cos(Math.toRadians(angleBPointC)));
            // Triangle 1

            drawTriangle(z1 + diffZ, z2 + diffZ, z3 + diffZ, x1 + diffX, y1 + diffY, x2 + diffX, y2+ diffY, x3+ diffX, y3+ diffY);
            // Triangle Opposite D B A
            drawTriangle(z3 + diffZ, z1 + diffZ, z4 + diffZ, x3+ diffX, y3+ diffY, x1+ diffX, y1+ diffY, x4+ diffX, y4+ diffY);


        }
    }
    private void drawTriangle(double z1, double z2, double z3, double x1, double y1, double x2, double y2, double x3, double y3) {
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1   1
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3, y3, z3));//p3

        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2    2
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3, y3, z3));//p3
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1

        this.stepDrawLinesForTriangle.add(getCartesianPoint(x3, y3, z3));//p3
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2
        this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1  //
    }
}
