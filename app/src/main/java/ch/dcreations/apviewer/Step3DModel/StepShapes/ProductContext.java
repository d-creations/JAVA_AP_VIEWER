package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class ProductContext implements StepShapes {

    String name;
    StepShapes frameReferenz;
    String disiplineType ;

    public ProductContext(String name, StepShapes frameReferenz, String disiplineType) {
        this.name = name;
        this.frameReferenz = frameReferenz;
        this.disiplineType = disiplineType;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_CONTEXT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(frameReferenz.getTreeItem());
        return treeItem;
    }

    @Override
    public String toString() {
        return AP242Code.PRODUCT_CONTEXT.toString() + "name";
    }
}
