package ch.dcreations.apviewer.Step3DModel.StepShapes;

import java.util.Set;

public class DefinitionalRepresentation implements StepShapes {
    String name;
    Set<StepShapes> items;
    StepShapes representationContext;

    public DefinitionalRepresentation(String name, Set<StepShapes> items, StepShapes representationContext) {
        this.name = name;
        this.items = items;
        this.representationContext = representationContext;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.DEFINITIONAL_REPRESENTATION;
    }
}
