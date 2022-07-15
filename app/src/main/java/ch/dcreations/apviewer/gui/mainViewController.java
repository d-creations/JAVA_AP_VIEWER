package ch.dcreations.apviewer.gui;

import ch.dcreations.apviewer.Step3DModel.Step3DModel;
import ch.dcreations.apviewer.config.LogConfiguration;
import ch.dcreations.apviewer.fileHandler.FileHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainViewController {

    private static final Logger logger = Logger.getLogger(LogConfiguration.class.getCanonicalName());
    double xPos = 0;
    double yPos = 0;
    ViewModel viewModel;
    MeshView meshView = new MeshView();
    Rotate rotateX = new Rotate();
    Rotate rotateY = new Rotate();
    FileHandler fileHandler;
    Step3DModel step3DModel;
    Stage stage;
    SubScene subScene;

    @FXML
    private AnchorPane DrawingPane;
    private Group subGroup;
    private Camera camera;

    @FXML
    void initialize() {
        viewModel = new ViewModel();
        viewModel.addPropertyChangeListener(evt -> {


            for (Step3DModel step3DModel1 : viewModel.step3DModels) {
                for (MeshView shape : step3DModel1.getShapes2DMesh()) {
                    shape.setTranslateX(150);
                    shape.setTranslateY(150);
                    shape.setMaterial(new PhongMaterial(Color.CORNFLOWERBLUE));
                    shape.setCullFace(CullFace.BACK);


                    shape.getTransforms().add(new Scale(2, 2));
                    rotateX.setAxis(new Point3D(1, 0, 0));
                    rotateY.setAxis(new Point3D(0, 1, 0));
                    shape.getTransforms().add(rotateX);
                    shape.getTransforms().add(rotateY);
                    subGroup.getChildren().add(shape);
                }
            }
        });
    }


    public void setStage(Stage stage, Group subPane) {
        this.stage = stage;
        this.subGroup = subPane;
    }

    @FXML
    private void selectAFile() throws IOException {
        step3DModel = new Step3DModel();
        if (stage == null) {
            logger.log(Level.WARNING, "stage null");
        } else {
            try {
                fileHandler = new FileHandler(stage, step3DModel);
            } catch (IOException e) {
                throw new IOException("file not found");
            }
            fileHandler.getAFile();
        }
        viewModel.addStepModel(step3DModel);

    }

    @FXML
    private void mouseHandler(MouseEvent event) {

        if (true) {
            double diff = getMouseX(event) - xPos;
            rotateY.setAngle((rotateY.getAngle() - diff));
            xPos = getMouseX(event);
            diff = getMouseY(event) - yPos;
            rotateX.setAngle((rotateX.getAngle() + diff));
            yPos = getMouseY(event);


        }


    }

    @FXML
    private void mousePressed(MouseEvent event) {
        xPos = getMouseX(event);
        yPos = getMouseY(event);
    }

    private double getMouseX(MouseEvent event) {
        return event.getX();
    }


    private double getMouseY(MouseEvent event) {
        return event.getY();
    }


    public void closeController() {
        logger.log(Level.WARNING, "Close Window");
    }

    public void addSubScene(SubScene subScene) {
        this.subScene = subScene;
        DrawingPane.getChildren().add(subScene);
        subScene.setWidth(300);
        subScene.setHeight(300);
        //final PerspectiveCamera camera = new PerspectiveCamera(false);
        //camera.setNearClip(0.1);
        //camera.setFarClip(10000.0);
        //camera.setTranslateZ(-100);
        //subScene.setCamera(camera);
    }
}
