package ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape3D;

import java.util.*;

abstract class ConnectedFaceSet implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name ;
    protected Set<Face> setOfFaces;
    public ConnectedFaceSet(String name, Set<Face> setOfFaces) {
        this.name = name;
        this.setOfFaces = setOfFaces;
    }

    public Set<Face> getSetOfFaces() {
        return Set.copyOf(setOfFaces);
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.CONNECTED_FACE_SET;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(Face face : this.getSetOfFaces()){
            treeItem.getChildren().add(face.getTreeItem());
        }
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.CONNECTED_FACE_SET.toString() + " "+ name;
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
