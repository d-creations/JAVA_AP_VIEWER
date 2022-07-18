package ch.dcreations.apviewer.Step3DModel.StepShapes;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;
import javafx.scene.shape.Shape3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductDefinitionContext implements StepShapes {

    protected final List<Map<String, String>> preferencesMapList = new ArrayList<>();

    protected String name;
    protected StepShapes calculationDecoding;
    protected String disciplineType;

    public ProductDefinitionContext(String name, StepShapes calculationDecoding, String disciplineType) {
        this.name = name;
        this.calculationDecoding = calculationDecoding;
        this.disciplineType = disciplineType;
    }

    @Override
    public AP242Code getTyp() {
        return AP242Code.PRODUCT_DEFINITION_CONTEXT;
    }

    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(calculationDecoding.getTreeItem());
        return treeItem;
    }
    @Override
    public String toString() {
        return AP242Code.PRODUCT_DEFINITION_CONTEXT + " " + name;
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
