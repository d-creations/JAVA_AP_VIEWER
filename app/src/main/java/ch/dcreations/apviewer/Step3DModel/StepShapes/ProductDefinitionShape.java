package ch.dcreations.apviewer.Step3DModel.StepShapes;

public class ProductDefinitionShape implements StepShapes {
    String name ;
    String description;
    StepShapes definition;

    public ProductDefinitionShape(String name, String description, StepShapes definition) {
        this.name = name;
        this.description = description;
        this.definition = definition;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION_SHAPE;
    }
}
