package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;

import java.util.Set;

public class FaceSurface extends Face{
    boolean sameSense;
    Surface faceGeometrie;

    public FaceSurface(String name, Set<FaceBound> faceBounds, Surface faceGeometrie, boolean sameSense) {
        super(name, faceBounds);
        this.faceGeometrie = faceGeometrie;
        this.sameSense = sameSense;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.FACE;
    }
}
