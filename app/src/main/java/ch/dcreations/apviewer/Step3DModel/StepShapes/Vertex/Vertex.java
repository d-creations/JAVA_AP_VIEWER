package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class Vertex implements StepShapes {

    String name;

    public Vertex(String name) {
        this.name = name;
    }



    @Override
    public AP242Code getTyp() {
        return AP242Code.VERTEX;
    }
}
