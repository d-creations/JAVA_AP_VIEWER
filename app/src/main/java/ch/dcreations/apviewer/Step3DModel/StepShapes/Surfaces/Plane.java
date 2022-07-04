package ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.ElementarySurface;

public class Plane extends ElementarySurface implements StepShapes {

    public Plane(String name, Axis2Placement3D position) {
        super(name,position);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PLANE;
    }
}
