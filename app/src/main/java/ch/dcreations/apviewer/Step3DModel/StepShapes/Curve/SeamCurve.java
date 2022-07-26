package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.PreferredSurfaceCurveRepresentation;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public class SeamCurve extends SurfaceCurve{
    public SeamCurve(String name, Curve curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation, int lineNumber) {
        super(name, curve, items, representation, AP242Code.SEAM_CURVE ,lineNumber);
    }
}
