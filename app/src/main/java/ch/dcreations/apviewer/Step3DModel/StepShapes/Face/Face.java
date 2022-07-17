package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import com.sun.source.tree.Tree;
import javafx.scene.control.TreeItem;

import java.util.Set;

public abstract class Face implements StepShapes {
    String name;
   Set<FaceBound> FaceBound;

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
        return AP242Code.FACE_BOUND.toString() + "name";
    }
}
