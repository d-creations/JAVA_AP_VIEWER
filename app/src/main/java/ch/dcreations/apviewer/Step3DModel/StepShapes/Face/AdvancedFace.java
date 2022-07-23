package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
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
        if (faceGeometrie.getTyp() == AP242Code.PLANE) {
            renderPlan();
        }
        if (faceGeometrie.getTyp() == AP242Code.SPHERICAL_SURFACE ){
            SphericalSurface sphericalSurface = (SphericalSurface) faceGeometrie;
            double radius = sphericalSurface.getRadius();
            renderSphericalSurface(radius);
        }
    }

    private void renderSphericalSurface(double radius) {

        Double z3 = radius;
        for (int i = 0;i<8;i++ ) {
            Double x1 = radius;
            Double y1 = 0.0;
            Double z1 = 0.0;
            Double x2 = 0.0;
            Double y2 = radius;
            Double z2 = 0.0;
            Double x3 = 0.0;
            Double y3 = 0.0;
            switch (i) {
                case 1, 5 -> y2 = -radius;
                case 2, 6 -> x1 = -radius;
                case 3, 7 -> {
                    x1 = -radius;
                    y2 = -radius;
                }
                case 4 -> z3 = -radius;
                default -> {
                }
            }


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
                List<Edge> tempAllEdges = new ArrayList<>(face.getEdgeLoop().getOrientedEdges());
                for (int i = 0; i < tempAllEdges.size(); i++) {
                    Double x1 = tempAllEdges.get(0).getStartX();
                    Double y1 = tempAllEdges.get(0).getStartY();
                    Double z1 = tempAllEdges.get(0).getStartZ();
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1   -1
                    Double x2 = tempAllEdges.get(0).getEndX();
                    Double y2 = tempAllEdges.get(0).getEndY();
                    Double z2 = tempAllEdges.get(0).getEndZ();
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2    -2
                    Double x3 = tempAllEdges.get(i).getStartX();
                    Double y3 = tempAllEdges.get(i).getStartY();
                    Double z3 = tempAllEdges.get(i).getStartZ();
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x3, y3, z3));//p3      -END
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p4     -1
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//P5      -2
                    double x4 = tempAllEdges.get(i).getEndX();
                    double y4 = tempAllEdges.get(i).getEndY();
                    double z4 = tempAllEdges.get(i).getEndZ();
                    addTriangles(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
                    x1 = tempAllEdges.get(tempAllEdges.size() - 1).getStartX();
                    y1 = tempAllEdges.get(tempAllEdges.size() - 1).getStartY();
                    z1 = tempAllEdges.get(tempAllEdges.size() - 1).getStartZ();
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x1, y1, z1));//p1   -1
                    x2 = tempAllEdges.get(tempAllEdges.size() - 1).getEndX();
                    y2 = tempAllEdges.get(tempAllEdges.size() - 1).getEndY();
                    z2 = tempAllEdges.get(tempAllEdges.size() - 1).getEndZ();
                    this.stepDrawLinesForTriangle.add(getCartesianPoint(x2, y2, z2));//p2    -2
                    x3 = tempAllEdges.get(i).getEndX();
                    y3 = tempAllEdges.get(i).getEndY();
                    z3 = tempAllEdges.get(i).getEndZ();
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
}
