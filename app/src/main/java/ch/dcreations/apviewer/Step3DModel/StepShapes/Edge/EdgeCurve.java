package ch.dcreations.apviewer.Step3DModel.StepShapes.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;

public class EdgeCurve extends Edge implements StepShapes {
    StepShapes edgeGeometrie; //vertex
    Boolean sameSense;//vertex

    public EdgeCurve(String name, Vertex edgeStart, Vertex edgeEnd, StepShapes edgeGeometrie, Boolean sameSense) {
        super(name,edgeStart,edgeEnd);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }
    public EdgeCurve(String name, VertexPoint edgeStart, VertexPoint edgeEnd, StepShapes edgeGeometrie, Boolean sameSense) {
        super(name,edgeStart,edgeEnd);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }
    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_CURVE;
    }
}
