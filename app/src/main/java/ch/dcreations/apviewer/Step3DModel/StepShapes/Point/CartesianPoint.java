package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.*;

public class CartesianPoint extends Point implements StepShapes {


    Map<CartasianAxisE,Double> directionValueMap = new TreeMap<>();
    public CartesianPoint(String name, List<Double> directionRatios) {
        super(name);
        List<CartasianAxisE> axisEList = new ArrayList<>();
        axisEList.add(CartasianAxisE.X);
        axisEList.add(CartasianAxisE.Y);
        axisEList.add(CartasianAxisE.Z);
        Iterator<CartasianAxisE> i = axisEList.iterator();
        for (Double directions: directionRatios){
            directionValueMap.put(i.next(),directions.doubleValue());
        }
    }


    @Override
    public Map<CartasianAxisE,Double> getPoint() {
        return Map.copyOf(this.directionValueMap);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.CARTESIAN_POINT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.CARTESIAN_POINT.toString() + "name";
    }
}
