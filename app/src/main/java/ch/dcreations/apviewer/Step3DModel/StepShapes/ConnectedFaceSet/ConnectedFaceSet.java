package ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.*;

abstract class ConnectedFaceSet extends StepShapes {

    protected Set<Face> setOfFaces;
    public ConnectedFaceSet(String name, Set<Face> setOfFaces,int lineNumber) {
        this(name,setOfFaces,lineNumber,AP242Code.CONNECTED_FACE_SET);
    }

    public ConnectedFaceSet(String name, Set<Face> setOfFaces,int lineNumber,AP242Code ap242Code) {
        super(ap242Code,name,lineNumber);
        this.name = name;
        this.setOfFaces = setOfFaces;
    }

    public Set<Face> getSetOfFaces() {
        return Set.copyOf(setOfFaces);
    }


    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        for(Face face : this.getSetOfFaces()){
            treeItem.getChildren().add(face.getTreeItem());
        }
        return treeItem;
    }
}
