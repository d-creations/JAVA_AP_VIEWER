package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public class EdgeLoop implements StepShapes {
    String name;
    Set<StepShapes> orientedEdges;

    public EdgeLoop(String name, Set<StepShapes> orientedEdges) {
        this.name = name;
        this.orientedEdges = orientedEdges;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_LOOP;
    }
}
