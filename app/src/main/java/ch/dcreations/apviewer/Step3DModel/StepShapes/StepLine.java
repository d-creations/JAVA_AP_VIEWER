package ch.dcreations.apviewer.Step3DModel.StepShapes;


import javafx.scene.control.TreeItem;

public class StepLine extends StepShapes {

    protected StepShapes coordinateSystem;
    protected StepShapes vector;

    public StepLine(String name, StepShapes coordinateSystem, StepShapes vector,int lineNumber) {
        super(AP242Code.LINE,name,lineNumber);
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
