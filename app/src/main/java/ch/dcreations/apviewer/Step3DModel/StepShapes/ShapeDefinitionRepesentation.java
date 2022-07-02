package ch.dcreations.apviewer.Step3DModel.StepShapes;

public class ShapeDefinitionRepesentation implements StepShapes{

    ProductDefinitionShape PRODUCT_DEFINITION_SHAPE;
    AdvancedBrepShapeRepresentation ADVANCED_BREP_SHAPE_REPRESENTATION;

    public ShapeDefinitionRepesentation(StepShapes productDefinitionShape, StepShapes advancedBrepShapeRepresentation) {
        this.ADVANCED_BREP_SHAPE_REPRESENTATION = (AdvancedBrepShapeRepresentation) advancedBrepShapeRepresentation;
        this.PRODUCT_DEFINITION_SHAPE = (ProductDefinitionShape) productDefinitionShape;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.SHAPE_DEFINITION_REPRESENTATION;
    }

}
