package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FaceBound implements StepShapes {
    String name;
    Loop faceLoop;

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    EdgeLoop edgeLoop = null;
    Boolean orientation;
    List<CartesianPoint> stepDrawLinesForTriangle = new ArrayList<>();

    public FaceBound(String name, Loop faceLoop, Boolean orientation) {
        this.name = name;
        this.faceLoop = faceLoop;
        this.orientation = orientation;
        render();
    }
    public FaceBound(String name, EdgeLoop faceLoop, Boolean orientation) {
        this.name = name;
        this.faceLoop = faceLoop;
        this.edgeLoop = faceLoop;
        this.orientation = orientation;
        this.edgeLoop.getOrientedEdges();
        render();


    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.FACE_BOUND;
    }

// DRAWING
    public List<CartesianPoint> getStepDrawTriangleLines() {
        return stepDrawLinesForTriangle;
    }
    public void render(){
        List<Edge> tempAllEdges = new ArrayList<>(this.edgeLoop.getOrientedEdges());
            for (int i = 0;i<tempAllEdges.size();i++){
                Double x1 = tempAllEdges.get(0).getStartX();
                Double y1 = tempAllEdges.get(0).getStartY();
                Double z1 = tempAllEdges.get(0).getStartZ();
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x1,y1,z1));//p1   -1
                Double x2 = tempAllEdges.get(0).getEndX();
                Double y2 = tempAllEdges.get(0).getEndY();
                Double z2 = tempAllEdges.get(0).getEndZ();
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x2,y2,z2));//p2    -2
                Double x3 = tempAllEdges.get(i).getStartX();
                Double y3 = tempAllEdges.get(i).getStartY();
                Double z3 = tempAllEdges.get(i).getStartZ();
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x3,y3,z3));//p3      -END
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x1,y1,z1));//p4     -1
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x2,y2,z2));//P5      -2
                double x4 = tempAllEdges.get(i).getEndX();
                double y4 = tempAllEdges.get(i).getEndY();
                double z4 = tempAllEdges.get(i).getEndZ();
                addTriangles(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
                x1 = tempAllEdges.get(tempAllEdges.size()-1).getStartX();
                 y1 = tempAllEdges.get(tempAllEdges.size()-1).getStartY();
                 z1 = tempAllEdges.get(tempAllEdges.size()-1).getStartZ();
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x1,y1,z1));//p1   -1
                 x2 = tempAllEdges.get(tempAllEdges.size()-1).getEndX();
                 y2 = tempAllEdges.get(tempAllEdges.size()-1).getEndY();
                 z2 = tempAllEdges.get(tempAllEdges.size()-1).getEndZ();
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x2,y2,z2));//p2    -2
                 x3 = tempAllEdges.get(i).getEndX();
                 y3 = tempAllEdges.get(i).getEndY();
                 z3 = tempAllEdges.get(i).getEndZ();
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x3,y3,z3));//p3      -END
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x1,y1,z1));//p4     -1
                this.stepDrawLinesForTriangle.add(getCartesianPoint(x2,y2,z2));//P5      -2
                 x4 = tempAllEdges.get(i).getStartX();
                 y4 = tempAllEdges.get(i).getStartY();
                 z4 = tempAllEdges.get(i).getStartZ();
                addTriangles(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
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
        return new CartesianPoint("",directions);
    }


    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(Edge cartesianPoint : this.edgeLoop.getOrientedEdges()){
            treeItem.getChildren().add(cartesianPoint.getTreeItem());
        }
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.FACE_BOUND + " " + name;
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }


    @Override
    public Shape3D getShape() {
        return null;
    }
}
