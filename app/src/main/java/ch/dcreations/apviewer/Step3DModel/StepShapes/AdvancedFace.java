package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;

import java.util.Set;

public class AdvancedFace implements StepShapes {
    String name;
    Set<FaceBound> setOfFaces;  // FACE BOUND
    Surface faceGeometrie;    // PLANE
    Boolean sameSense;

    public AdvancedFace(String name, Set<FaceBound> setOfFaces, Surface faceGeometrie, Boolean sameSense) {
        this.name = name;
        this.setOfFaces = setOfFaces;
        this.faceGeometrie = faceGeometrie;
        this.sameSense = sameSense;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ADVANCED_FACE;
    }
}
