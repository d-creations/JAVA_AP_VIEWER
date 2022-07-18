package ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.shape.Shape3D;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ElementarySurface extends Surface implements StepShapes {

    protected Axis2Placement3D position;

    public ElementarySurface(String name,Axis2Placement3D position) {
        super(name);
        this.position = position;
    }

    @Override
    public String toString() {
        return AP242Code.ELEMENTARY_SURFACE + " " + name;
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
    public Shape3D getShape() {
        return null;
    }
}
