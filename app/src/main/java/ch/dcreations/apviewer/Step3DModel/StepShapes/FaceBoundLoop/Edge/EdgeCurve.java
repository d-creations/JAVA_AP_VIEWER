package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Curve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;


/**
 * Ecken Kante
 */
public class EdgeCurve extends Edge implements StepShapes {
    Curve edgeGeometrie; //vertex
    Boolean sameSense;//vertex

    public EdgeCurve(String name, Vertex edgeStart, Vertex edgeEnd, Curve edgeGeometrie, Boolean sameSense) {
        super(name,edgeStart,edgeEnd);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }
    public EdgeCurve(String name, VertexPoint edgeStart, VertexPoint edgeEnd, Curve edgeGeometrie, Boolean sameSense) {
        super(name,edgeStart,edgeEnd);
        this.edgeGeometrie = edgeGeometrie;
        this.sameSense = sameSense;
    }




    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_CURVE;
    }
}
