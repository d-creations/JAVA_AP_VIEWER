package ch.dcreations.apviewer.Step3DModel.Config;

import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.IncrementalPointsD;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Direction;

public class MathCalculations {

    public static IncrementalPointsD getCoordinatesInNewBasis(double x, double y, double z, Direction firstDirectionE, Direction secondDirectionE, Direction axis){
        double startX = y * firstDirectionE.getDirectionRatios().get(0) + x * secondDirectionE.getDirectionRatios().get(0) + z * axis.getDirectionRatios().get(0);
        double startY = y * firstDirectionE.getDirectionRatios().get(1) + x * secondDirectionE.getDirectionRatios().get(1) + z * axis.getDirectionRatios().get(1);
        double startZ = y * firstDirectionE.getDirectionRatios().get(2) + x * secondDirectionE.getDirectionRatios().get(2) + z * axis.getDirectionRatios().get(2);

        return new IncrementalPointsD(startX,startY,startZ);

    }

}
