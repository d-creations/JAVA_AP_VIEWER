package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.*;

public abstract class Face implements StepShapes {
    protected String name;
   protected Set<FaceBound> FaceBound;

   protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();


    public Face(String name, Set<FaceBound> faceBounds) {
        this.name = name;
        this.FaceBound = faceBounds;
    }

    public Set<FaceBound> getFaceBound() {
        return Set.copyOf(FaceBound);
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for (FaceBound faceBound : FaceBound){
            treeItem.getChildren().add(faceBound.getTreeItem());
        }
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.FACE.toString() + "name";
    }

    @Override
    public List<Map<String, String>> getPreferencesList() {
        return Collections.unmodifiableList(this.preferencesMapList);
    }

    @Override
    public boolean setPreference(Map<String, String> preference) {
        return false;
    }


    @Override
    public Shape3D getShape() {
        return null;
    }
}
