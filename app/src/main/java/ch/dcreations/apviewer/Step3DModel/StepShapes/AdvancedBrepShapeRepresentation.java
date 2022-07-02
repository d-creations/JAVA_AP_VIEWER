package ch.dcreations.apviewer.Step3DModel.StepShapes;

import java.util.Set;

public class AdvancedBrepShapeRepresentation implements  StepShapes{

    String name ;
    Set<StepShapes> items;
    StepShapes context;

    public AdvancedBrepShapeRepresentation(String name, Set<StepShapes> items, StepShapes context) {
        this.name = name;
        this.items = items;
        this.context = context;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ADVANCED_BREP_SHAPE_REPRESENTATION;
    }
}
