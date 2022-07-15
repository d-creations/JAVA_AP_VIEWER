package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;

import java.util.Map;

public class Edge implements StepShapes {
    String name;
    Vertex edgeStart;
    Vertex edgeEnd;

    double startX;
    double startY;
    double startZ;
    double endX;
    double endY;
    double endZ;

    public Edge(String name, Vertex edgeStart, Vertex edgeEnd) {
        this.name = name;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
        Point VertexStart = edgeStart.ifExistGivePoint();
        Point VertexEnd = edgeEnd.ifExistGivePoint();
        if (VertexStart != null && VertexEnd != null) {
            Map<CartasianAxisE, Double> pointStart = VertexStart.getPoint();
            Map<CartasianAxisE, Double> pointEnd = VertexEnd.getPoint();
            CartasianAxisE x = CartasianAxisE.X;
            CartasianAxisE y = CartasianAxisE.Y;
            CartasianAxisE z = CartasianAxisE.Z;
            startX = pointStart.get(x);
            startY = pointStart.get(y);
            startZ = pointStart.get(z);
            endX = pointEnd.get(x);
            endY = pointEnd.get(y);
            endZ = pointEnd.get(z);
        }
    }

    public Edge(String name, VertexPoint edgeStart, VertexPoint edgeEnd) {
        this.name = name;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
        Point VertexStart = edgeStart.ifExistGivePoint();
        Point VertexEnd = edgeEnd.ifExistGivePoint();
        if (VertexStart != null && VertexEnd != null) {
            Map<CartasianAxisE, Double> pointStart = VertexStart.getPoint();
            Map<CartasianAxisE, Double> pointEnd = VertexEnd.getPoint();
            CartasianAxisE x = CartasianAxisE.X;
            CartasianAxisE y = CartasianAxisE.Y;
            CartasianAxisE z = CartasianAxisE.Z;
            startX = pointStart.get(x);
            startY = pointStart.get(y);
            startZ = pointStart.get(z);
            endX = pointEnd.get(x);
            endY = pointEnd.get(y);
            endZ = pointEnd.get(z);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Vertex getEdgeStart() {
        return edgeStart;
    }

    public Vertex getEdgeEnd() {
        return edgeEnd;
    }

    public void setEdgeStart(Vertex edgeStart) {
        this.edgeStart = edgeStart;
    }

    public void setEdgeEnd(Vertex edgeEnd) {
        this.edgeEnd = edgeEnd;
    }
    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE;
    }


    //Drawing


    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getStartZ() {
        return startZ;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    public double getEndZ() {
        return endZ;
    }
}
