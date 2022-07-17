package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

public class Direction implements StepShapes {

    String name;
    List<Double> directionRatios = new ArrayList<>();
    public Direction(String name, List<Double> directionRatios) {
        this.name = name;
        for (Double directions: directionRatios){
            this.directionRatios.add(directions.doubleValue());
        }
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.DIRECTION;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.DIRECTION.toString() + "name";
    }
}
