package ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces;

import ch.dcreations.apviewer.Step3DModel.StepShapes.Axis2Placement3D;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class ElementarySurface extends Surface implements StepShapes {

    protected Axis2Placement3D position;

    public ElementarySurface(String name,Axis2Placement3D position) {
        super(name);
        this.position = position;
    }
}
