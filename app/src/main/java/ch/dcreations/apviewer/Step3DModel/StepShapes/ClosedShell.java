package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ClosedShell implements StepShapes {
    String name ;
    Set<StepShapes> setOfFaces = new HashSet<>();
    public ClosedShell(String name, Set<StepShapes> setOfFaces) {
        this.name = name;
        this.setOfFaces = setOfFaces;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.CLOSED_SHELL;
    }
}
