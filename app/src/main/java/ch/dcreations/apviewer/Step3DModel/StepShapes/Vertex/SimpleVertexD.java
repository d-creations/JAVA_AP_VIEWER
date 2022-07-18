package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

import ch.dcreations.apviewer.Step3DModel.StepShapes.AP242Code;
import javafx.scene.control.TreeItem;

public class SimpleVertexD extends Vertex{
    public SimpleVertexD(String name) {
        super(name);
    }

    @Override
    public <T> T ifExistGivePoint() {
        return null;
    }




}
