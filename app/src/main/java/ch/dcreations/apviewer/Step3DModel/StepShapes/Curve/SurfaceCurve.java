package ch.dcreations.apviewer.Step3DModel.StepShapes.Curve;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import ch.dcreations.apviewer.Step3DModel.StepShapes.PreferredSurfaceCurveRepresentation;
import ch.dcreations.apviewer.Step3DModel.StepShapes.StepShapes;
import javafx.scene.control.TreeItem;

import java.util.Set;

public class SurfaceCurve extends Curve {
    protected StepShapes curve;
    protected Set<StepShapes> items;
    protected PreferredSurfaceCurveRepresentation representation;

    public SurfaceCurve(String name, StepShapes curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation, AP242Code ap242Code, int lineNumber) {
        super(name, lineNumber, ap242Code);
        this.curve = curve;
        this.items = items;
        this.representation = representation;
    }

    public SurfaceCurve(String name, StepShapes curve, Set<StepShapes> items, PreferredSurfaceCurveRepresentation representation, int lineNumber) {
        this(name, curve, items, representation, AP242Code.SURFACE_CURVE, lineNumber);
    }
    @Override
    public TreeItem<StepShapes> getTreeItem() {
        TreeItem<StepShapes> treeItem = new TreeItem<>(this);
        treeItem.getChildren().add(curve.getTreeItem());
        for(StepShapes item : items){
            treeItem.getChildren().add(item.getTreeItem());
        }
        return treeItem;
    }
}
