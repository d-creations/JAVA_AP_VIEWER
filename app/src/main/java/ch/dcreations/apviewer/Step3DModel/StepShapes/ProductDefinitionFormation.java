package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

public class ProductDefinitionFormation implements StepShapes {
    String id;
    String description;
    StepShapes productReference;

    public ProductDefinitionFormation(String id, String description, StepShapes productReference) {
        this.id = id;
        this.description = description;
        this.productReference = productReference;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION_FORMATION;
    }
}
