package ch.dcreations.apviewer.Step3DModel.StepShapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class StepLine extends Line implements StepShapes {

    double posVecX;
    double PosVecY;
    double PosVecZ;
    double DirVecX;
    double DirVecY;
    double DirVecZ;
    double length;

    public StepLine(double posVecX, double posVecY, double posVecZ, double dirVecX, double dirVecY, double dirVecZ, double length) {
        super();
        this.posVecX = posVecX;
        PosVecY = posVecY;
        PosVecZ = posVecZ;
        DirVecX = dirVecX;
        DirVecY = dirVecY;
        DirVecZ = dirVecZ;
        this.length = length;
        this.setStroke(Color.BLUE);
        this.setStrokeWidth(5);;
        calcLine();
    }
    public void calcLine(){
        setStartX(posVecX);
        setStartY(PosVecY);
        double endX = posVecX+500;
        double endY = PosVecY+500;
        setEndX(endX);
        setEndY(endY);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.LINE;
    }
}
