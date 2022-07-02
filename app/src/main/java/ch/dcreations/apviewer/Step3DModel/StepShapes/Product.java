package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.Set;

public class Product implements StepShapes {


    String id;
    String name;
    String descrition;
    Set<StepShapes> frameReferences;

    public Product(String id, String name, String description, Set<StepShapes> frameReferences) {
        this.id = id;
        this.name = name;
        this.descrition = description;
        this.frameReferences = frameReferences;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT;
    }
}
