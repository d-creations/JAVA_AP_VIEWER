package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.PreferredSurfaceCurveRepresentation;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SurfaceCurve extends Curve implements StepShapes {
    protected String name;
    protected StepShapes curve;
    protected Set<StepShapes> items;
    protected PreferredSurfaceCurveRepresentation representation;

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

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }

    @Override
    public String toString() {
        return AP242Code.SURFACE_CURVE + " " + name ;
    }

}
