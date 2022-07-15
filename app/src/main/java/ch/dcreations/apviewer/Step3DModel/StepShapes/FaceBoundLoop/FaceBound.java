package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.ArrayList;
import java.util.List;

public class FaceBound implements StepShapes {
    String name;
    Loop faceLoop;

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

    public Loop getFaceLoop() {
        return faceLoop;
    }

    public EdgeLoop getEdgeLoop() {
        return edgeLoop;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.FACE_BOUND;
    }

// DRAWHING
    public List<CartesianPoint> getStepDrawTriangleLines() {
        return stepDrawLinesForTriangle;
    }
    public void render(){
        List<Edge> tempAllEdges = new ArrayList<>();
            for (Edge edge : this.edgeLoop.getOrientedEdges()) {
                tempAllEdges.add(edge);
            }
            for (int i = 0;i<tempAllEdges.size();i++){
                Double x1 = tempAllEdges.get(0).getStartX();
                Double y1 = tempAllEdges.get(0).getStartY();
                Double z1 = tempAllEdges.get(0).getStartZ();
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x1,y1,z1));
                Double x2 = tempAllEdges.get(0).getEndX();
                Double y2 = tempAllEdges.get(0).getEndY();
                Double z2 = tempAllEdges.get(0).getEndZ();
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x2,y2,z2));
                Double x3 = tempAllEdges.get(i).getEndX();
                Double y3 = tempAllEdges.get(i).getEndY();
                Double z3 = tempAllEdges.get(i).getEndZ();
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x3,y3,z3));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x1,y1,z1));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x2,y2,z2));
                Double x4 = tempAllEdges.get(i).getStartX();
                Double y4 = tempAllEdges.get(i).getStartY();
                Double z4 = tempAllEdges.get(i).getStartZ();
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x4,y4,z4));

                this.stepDrawLinesForTriangle.add(getCartasianPoint(x3,y3,z3));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x4,y4,z4));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x1,y1,z1));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x3,y3,z3));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x4,y4,z4));
                this.stepDrawLinesForTriangle.add(getCartasianPoint(x2,y2,z2));

            }
    }
    private CartesianPoint getCartasianPoint(Double x,Double y,Double z){
        List<Double> directions = new ArrayList<>();
        directions.add(x);
        directions.add(y);
        directions.add(z);
        CartesianPoint point = new CartesianPoint("",directions);
        return point;
    }
}
