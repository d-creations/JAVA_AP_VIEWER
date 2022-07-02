package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public class AdvancedFace implements StepShapes {
    String name;
    Set<StepShapes> setOfFaces;  // FACE BOUND
    StepShapes faceGeometrie;    // PLANE
    Boolean sameSense;

    public AdvancedFace(String name, Set<StepShapes> setOfFaces, StepShapes faceGeometrie, Boolean sameSense) {
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
