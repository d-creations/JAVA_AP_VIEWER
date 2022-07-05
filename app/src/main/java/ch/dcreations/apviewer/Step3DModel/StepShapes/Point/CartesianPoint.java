package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;

import java.util.ArrayList;
import java.util.List;

public class CartesianPoint extends Point implements StepShapes {

    List<Double> directionRatios = new ArrayList<>();
    public CartesianPoint(String name, List<Double> directionRatios) {
        super(name);
        for (Double directions: directionRatios){
            this.directionRatios.add(directions.doubleValue());
        }
    }
    @Override
    public AP242Code getTyp() {
        return AP242Code.CARTESIAN_POINT;
    }
}
