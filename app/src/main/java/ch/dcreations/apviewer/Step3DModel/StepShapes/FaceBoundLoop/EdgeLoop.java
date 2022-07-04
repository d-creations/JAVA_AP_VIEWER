package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public class EdgeLoop extends Loop implements StepShapes {

    Set<StepShapes> orientedEdges;

    public EdgeLoop(String name, Set<StepShapes> orientedEdges) {
        super(name);
        this.orientedEdges = orientedEdges;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.EDGE_LOOP;
    }
}
