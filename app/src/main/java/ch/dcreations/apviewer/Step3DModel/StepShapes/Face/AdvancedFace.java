package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.FaceSurface;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;

import java.util.Set;

public class AdvancedFace extends FaceSurface implements StepShapes {

    public AdvancedFace(String name, Set<FaceBound> setOfFaces, Surface faceGeometrie, Boolean sameSense) {
        super(name,setOfFaces,faceGeometrie,sameSense);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ADVANCED_FACE;
    }
}
