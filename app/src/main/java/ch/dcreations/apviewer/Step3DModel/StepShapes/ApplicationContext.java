package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class ApplicationContext implements StepShapes {
    public ApplicationContext(String name) {
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.APPLICATION_CONTEXT;
    }
}
