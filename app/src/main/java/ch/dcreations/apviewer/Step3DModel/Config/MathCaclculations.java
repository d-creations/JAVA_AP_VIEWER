package ch.dcreations.apviewer.Step3DModel.Config;

import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.IncrementalPointsD;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Direction;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartasianAxisE;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;

public class MathCaclculations {

    private static IncrementalPointsD xAxis = new IncrementalPointsD(1,0,0);
    private static IncrementalPointsD yAxis = new IncrementalPointsD(0,1,0);
    private static IncrementalPointsD zAxis = new IncrementalPointsD(0,0,1);

    static double getYtranformationWith3Angles(Direction direction, int yDistance, CartesianPoint translation){
        IncrementalPointsD directionAxis = new IncrementalPointsD(direction.getDirectionRatios().get(0),direction.getDirectionRatios().get(1),direction.getDirectionRatios().get(2));
        return (yAxis.y()*directionAxis.y())/Math.sqrt(directionAxis.x()*directionAxis.x()+directionAxis.y()*directionAxis.y()+directionAxis.y()*directionAxis.y())*yDistance+translation.getPoint().get(CartasianAxisE.Y);
    };
}
