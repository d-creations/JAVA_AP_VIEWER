package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Curve extends StepShapes {

    protected List<IncrementalPointsD> edgeDrawingPoints = new ArrayList<>();

    public Curve(String name, int fileLineNumber) {
        this(name, fileLineNumber,AP242Code.CURVE);
    }

    protected Curve(String name, int fileLineNumber,AP242Code ap242Code) {
        super(ap242Code, name, fileLineNumber);
    }




    public List<IncrementalPointsD> getEdgeDrawingPoints(VertexPoint start,VertexPoint end) {
        return Collections.unmodifiableList(edgeDrawingPoints);
    }


}
