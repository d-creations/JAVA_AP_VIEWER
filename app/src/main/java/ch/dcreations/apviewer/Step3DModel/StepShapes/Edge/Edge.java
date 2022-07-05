package ch.dcreations.apviewer.Step3DModel.StepShapes.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;

public class Edge implements StepShapes {
    String name;
    Vertex edgeStart;
    Vertex edgeEnd;

    public Edge(String name, Vertex edgeStart, Vertex edgeEnd) {
        this.name = name;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
    }

    public Edge(String name, VertexPoint edgeStart, VertexPoint edgeEnd) {
        this.name = name;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
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
}
