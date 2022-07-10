package ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClosedShell extends ConnectedFaceSet implements StepShapes {

    public ClosedShell(String name, Set<Face> setOfFaces) {
        super(name,setOfFaces);
      }

    private void drawingShell() {

    }


    @Override
    public AP242Code getTyp() {
        return AP242Code.CLOSED_SHELL;
    }
}
