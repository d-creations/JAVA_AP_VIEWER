package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;


import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Curve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

public class StepLine extends Curve {

    protected StepShapes coordinateSystem;
    protected StepShapes vector;

    public StepLine(String name, StepShapes coordinateSystem, StepShapes vector,int lineNumber) {
        super(name,lineNumber,AP242Code.LINE);
        this.coordinateSystem = coordinateSystem;
        this.vector = vector;
    }
    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(coordinateSystem.getTreeItem());
        treeItem.getChildren().add(vector.getTreeItem());
        return treeItem;
    }

}
