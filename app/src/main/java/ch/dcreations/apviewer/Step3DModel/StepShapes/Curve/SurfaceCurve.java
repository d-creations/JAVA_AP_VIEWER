package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.PreferredSurfaceCurveRepresentation;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import java.util.Set;

public class SurfaceCurve extends Curve {
    protected StepShapes curve;
    protected Set<StepShapes> items;
    protected PreferredSurfaceCurveRepresentation representation;

    public SurfaceCurve(String name, StepShapes curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation,AP242Code ap242Code,int lineNumber) {
        super(name, lineNumber, ap242Code);
        this.curve = curve;
        this.items = items;
        this.representation = representation;
    }
    public SurfaceCurve(String name, StepShapes curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation,int lineNumber) {
    this(name,curve,items,representation,AP242Code.SURFACE_CURVE,lineNumber);
    }

    }
