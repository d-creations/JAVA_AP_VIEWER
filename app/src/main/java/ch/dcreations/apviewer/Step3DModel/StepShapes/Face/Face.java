package ch.dcreations.apviewer.Step3DModel.StepShapes.Face;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.*;

public abstract class Face extends StepShapes {
   protected Set<FaceBound> FaceBound;


    public Face(String name, Set<FaceBound> faceBounds,int lineNumber) {
        super(AP242Code.FACE_BOUND,name,lineNumber);
        this.FaceBound = faceBounds;
    }


    public Face(String name, Set<FaceBound> faceBounds,int lineNumber,AP242Code ap242Code) {
        super(ap242Code,name,lineNumber);
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
}
