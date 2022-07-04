package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class FaceBound implements StepShapes {
    String name;
    StepShapes faceLoop;
    Boolean orientation;

    public FaceBound(String name, StepShapes faceLoop, Boolean orientation) {
        this.name = name;
        this.faceLoop = faceLoop;
        this.orientation = orientation;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.FACE_BOUND;
    }
}
