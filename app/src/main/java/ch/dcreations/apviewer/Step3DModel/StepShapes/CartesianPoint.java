package ch.dcreations.apviewer.Step3DModel.StepShapes;

import java.util.ArrayList;
import java.util.List;

public class CartesianPoint implements StepShapes {

    String name;
    List<Double> directionRatios = new ArrayList<>();
    public CartesianPoint(String name, List<Double> directionRatios) {
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
