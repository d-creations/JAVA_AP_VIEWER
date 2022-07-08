package ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.HashSet;
import java.util.Set;

abstract class ConnectedFaceSet implements StepShapes {

    protected String name ;
    protected Set<Face> setOfFaces = new HashSet<>();

    public ConnectedFaceSet(String name, Set<Face> setOfFaces) {
        this.name = name;
        this.setOfFaces = setOfFaces;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.CONNECTED_FACE_SET;
    }
}
