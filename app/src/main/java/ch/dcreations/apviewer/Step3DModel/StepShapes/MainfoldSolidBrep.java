package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;


public class MainfoldSolidBrep implements StepShapes {

    String name;
    StepShapes shapeData;
    public MainfoldSolidBrep(String name, StepShapes stepShapes) {
        this.name = name;
        this.shapeData = stepShapes;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.MANIFOLD_SOLID_BREP;
    }
}
