package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public abstract class Face implements StepShapes {
    String name;
   Set<FaceBound> FaceBound;

    public Face(String name, Set<FaceBound> faceBounds) {
        this.name = name;
        this.FaceBound = faceBounds;
    }

    public Set<FaceBound> getFaceBound() {
        return Set.copyOf(FaceBound);
    }
}
