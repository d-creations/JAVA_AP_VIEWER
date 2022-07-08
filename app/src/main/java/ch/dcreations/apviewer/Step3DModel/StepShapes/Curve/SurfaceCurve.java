package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.PreferredSurfaceCurveRepresentation;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public class SurfaceCurve extends Curve implements StepShapes {
    String name;
    StepShapes curve;
    Set<StepShapes> items;
    PreferredSurfaceCurveRepresentation representation;

    public SurfaceCurve(String name, StepShapes curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation) {
        this.name = name;
        this.curve = curve;
        this.items = items;
        this.representation = representation;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.SURFACE_CURVE;
    }
}
