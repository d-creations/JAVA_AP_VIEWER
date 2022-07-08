package ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex;

public class SimpleVertexD extends Vertex{
    public SimpleVertexD(String name) {
        super(name);
    }

    @Override
    public <T> T ifExistGivePoint() {
        return null;
    }
}
