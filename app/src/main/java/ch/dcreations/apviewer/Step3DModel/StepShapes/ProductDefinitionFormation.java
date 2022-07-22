package ch.dcreations.apviewer.Step3DModel.StepShapes;


import javafx.scene.control.TreeItem;

public class ProductDefinitionFormation extends StepShapes {

    protected String id;
    protected String description;
    protected StepShapes productReference;

    public ProductDefinitionFormation(String id, String description, StepShapes productReference,int lineNumber) {
        super(AP242Code.PRODUCT_DEFINITION_FORMATION,"",lineNumber);
        this.id = id;
        this.description = description;
        this.productReference = productReference;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(productReference.getTreeItem());
        return treeItem;
    }


}
