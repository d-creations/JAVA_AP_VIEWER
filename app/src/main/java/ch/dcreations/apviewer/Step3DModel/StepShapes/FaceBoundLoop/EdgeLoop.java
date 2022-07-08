package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Map;
import java.util.Set;

public class EdgeLoop extends Loop implements StepShapes {

    Set<Edge> orientedEdges;

    public EdgeLoop(String name, Set<Edge> orientedEdges) {
        super(name);
        this.orientedEdges = orientedEdges;
    }

    public Set<Edge> getOrientedEdges() {
        return Set.copyOf(orientedEdges);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_LOOP;
    }
}
