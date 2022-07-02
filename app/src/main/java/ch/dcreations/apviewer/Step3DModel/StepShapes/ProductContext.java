package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class ProductContext implements StepShapes {

    String name;
    StepShapes frameReferenz;
    String disiplineType ;

    public ProductContext(String name, StepShapes frameReferenz, String disiplineType) {
        this.name = name;
        this.frameReferenz = frameReferenz;
        this.disiplineType = disiplineType;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_CONTEXT;
    }
}
