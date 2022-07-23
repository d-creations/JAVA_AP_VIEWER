package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;
import java.util.Set;

public class FaceSurface extends Face {
    protected boolean sameSense;
    protected Surface faceGeometrie;

    public FaceSurface(String name, Set<FaceBound> faceBounds, Surface faceGeometrie, boolean sameSense,int lineNumber) {
        this(name,faceBounds,faceGeometrie,sameSense,lineNumber,AP242Code.FACE_SURFACE);
    }
    public FaceSurface(String name, Set<FaceBound> faceBounds, Surface faceGeometrie, boolean sameSense,int lineNumber,AP242Code ap242Code) {
        super(name, faceBounds,lineNumber,ap242Code);
        this.faceGeometrie = faceGeometrie;
        this.sameSense = sameSense;
    }
}
