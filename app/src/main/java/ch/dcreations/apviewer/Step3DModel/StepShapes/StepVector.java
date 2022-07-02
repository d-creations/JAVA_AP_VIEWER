package ch.dcreations.apviewer.Step3DModel.StepShapes;

public class StepVector implements StepShapes{

    String name;
    StepShapes orientation;
    Double length;

    public StepVector(String name, StepShapes orientation, Double length) {
        this.name = name;
        this.orientation = orientation;
        this.length = length;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.VECTOR;
    }
}
