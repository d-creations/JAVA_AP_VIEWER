package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.ArrayList;
import java.util.List;

public class cartesianPoint implements StepShapes {

    String name;
    List<Double> directionRatios = new ArrayList<>();
    public cartesianPoint(String name, List<Double> directionRatios) {
        this.name = name;
        for (Double directions: directionRatios){
            this.directionRatios.add(directions.doubleValue());
        }
    }
    @Override
    public AP242Code getTyp() {
        return AP242Code.CARTESIAN_POINT;
    }
}
