package ch.dcreations.apviewer.Step3DModel.StepShapes.Point;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.*;

public class CartesianPoint extends Point implements StepShapes {

    protected Map<CartasianAxisE,Double> directionValueMap = new TreeMap<>();
    public CartesianPoint(String name, List<Double> directionRatios) {
        super(name);
        List<CartasianAxisE> axisEList = new ArrayList<>();
        axisEList.add(CartasianAxisE.X);
        axisEList.add(CartasianAxisE.Y);
        axisEList.add(CartasianAxisE.Z);
        Iterator<CartasianAxisE> i = axisEList.iterator();
        for (Double directions: directionRatios){
            directionValueMap.put(i.next(), directions);
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
        return new TreeItem<>(this);
    }

    @Override
    public String toString() {
        return AP242Code.CARTESIAN_POINT + " " + name;
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }

}
