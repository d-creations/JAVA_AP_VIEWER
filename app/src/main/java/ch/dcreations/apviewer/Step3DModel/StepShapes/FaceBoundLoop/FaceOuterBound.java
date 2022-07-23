package ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;

public class FaceOuterBound extends FaceBound {
    public FaceOuterBound(String name, Loop faceLoop, Boolean orientation, int lineNumber) {
        super(name, faceLoop, orientation, lineNumber,AP242Code.FACE_OUTER_BOUND);
    }

    public FaceOuterBound(String name, EdgeLoop faceLoop, Boolean orientation, int lineNumber) {
        super(name, faceLoop, orientation, lineNumber,AP242Code.FACE_OUTER_BOUND);
    }
}
