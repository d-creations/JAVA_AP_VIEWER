package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class FaceBound implements StepShapes {
    String name;
    Loop faceLoop;

    EdgeLoop edgeLoop = null;
    Boolean orientation;

    public FaceBound(String name, Loop faceLoop, Boolean orientation) {
        this.name = name;
        this.faceLoop = faceLoop;
        this.orientation = orientation;
    }
    public FaceBound(String name, EdgeLoop faceLoop, Boolean orientation) {
        this.name = name;
        this.faceLoop = faceLoop;
        this.edgeLoop = faceLoop;
        this.orientation = orientation;
    }

    public Loop getFaceLoop() {
        return faceLoop;
    }

    public EdgeLoop getEdgeLoop() {
        return edgeLoop;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.FACE_BOUND;
    }
}
