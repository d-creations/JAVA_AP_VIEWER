package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceSurface extends Face implements StepShapes {
    protected boolean sameSense;
    protected Surface faceGeometrie;

    public FaceSurface(String name, Set<FaceBound> faceBounds, Surface faceGeometrie, boolean sameSense) {
        super(name, faceBounds);
        this.faceGeometrie = faceGeometrie;
        this.sameSense = sameSense;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.FACE_SURFACE;
    }

    @Override
    public String toString() {
        return AP242Code.FACE_SURFACE + " " + name ;
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }
}
