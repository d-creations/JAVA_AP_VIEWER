package ch.dcreations.apviewer.gui;

import ch.dcreations.apviewer.Step3DModel.Step3DModel;
import ch.dcreations.apviewer.config.LogConfiguration;
import ch.dcreations.apviewer.fileHandler.FileHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.File;
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

    @FXML
    private AnchorPane DrawingPane;

    @FXML
    void initialize(){
        viewModel = new ViewModel();
        viewModel.addPropertyChangeListener(evt -> {
            for (Step3DModel step3DModel1 : viewModel.step3DModels) {
                for (Mesh shape : step3DModel1.getShapes2D()) {
                    meshView = new MeshView(shape);
                    meshView.setMaterial(new PhongMaterial(Color.FIREBRICK));
                    meshView.setCullFace(CullFace.NONE);
                    rotateX.setAxis(new Point3D(1,0,0));
                    rotateY.setAxis(new Point3D(0,1,0));
                    rotateX.setAngle(30);
                    rotateY.setAngle(30);
                    meshView.getTransforms().add(rotateX);
                    meshView.getTransforms().add(rotateY);
                    meshView.setTranslateX(150);
                    meshView.setTranslateY(150);
                    meshView.getTransforms().add(new Scale(2,2));
                    DrawingPane.getChildren().add(meshView);
                }
            }
        });
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void selectAFile() throws IOException {
        step3DModel = new Step3DModel();
        if (stage == null) {
            logger.log(Level.WARNING,"stage null");
        }else {
            try {
                fileHandler = new FileHandler(stage,step3DModel);
            } catch (IOException e) {
                throw new IOException("file not found");
            }
            fileHandler.getAFile();
        }
        viewModel.addStepModel(step3DModel);
    }

    @FXML
    private void mouseHandler(MouseEvent event) {

        if (true){
                    double diff = getMouseX(event) - xPos;
                    rotateX.setAngle(rotateX.getAngle()+diff);
                    xPos = getMouseX(event);
                    diff = getMouseY(event) - yPos;
                    rotateY.setAngle(rotateY.getAngle()+diff);
                    yPos = getMouseY(event);
        }


    }

    private double getMouseX(MouseEvent event) {
        return event.getX();
    }


    private double getMouseY(MouseEvent event) {
        return event.getY();
    }



    public void closeController() {
        logger.log(Level.WARNING,"Close Window");
    }
}
