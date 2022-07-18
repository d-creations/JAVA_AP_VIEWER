package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;
import javafx.scene.control.TreeItem;

import java.util.*;

public class AdvancedFace extends FaceSurface implements StepShapes {

    public AdvancedFace(String name, Set<FaceBound> setOfFaces, Surface faceGeometrie, Boolean sameSense) {
        super(name, setOfFaces, faceGeometrie, sameSense);
        Map<String,String> preferencesMap = new HashMap<>();
        preferencesMap.put("Same Sense",sameSense.toString());
        preferencesMapList.add(preferencesMap);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.ADVANCED_FACE;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(FaceBound faceBound : this.FaceBound){
            treeItem.getChildren().add(faceBound.getTreeItem());
        }
        treeItem.getChildren().add(faceGeometrie.getTreeItem());
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.ADVANCED_FACE + "" + name;
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
