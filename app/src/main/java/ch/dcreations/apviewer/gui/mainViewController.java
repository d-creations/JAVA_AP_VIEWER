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
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
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

    @FXML
    private AnchorPane DrawingPane;

    @FXML
    void initialize(){
        viewModel = new ViewModel();
        viewModel.addPropertyChangeListener(evt -> {




            for (Step3DModel step3DModel1 : viewModel.step3DModels) {
                for (MeshView shape  : step3DModel1.getShapes2DMesh()) {
                    shape.setTranslateX(150);
                    shape.setTranslateY(150);
                    shape.setMaterial(new PhongMaterial(Color.STEELBLUE));
                    shape.setCullFace(CullFace.NONE);

                    shape.getTransforms().add(new Scale(2,2));
                    rotateX.setAxis(new Point3D(1,0,0));
                    rotateY.setAxis(new Point3D(0,1,0));
                    shape.getTransforms().add(rotateX);
                    shape.getTransforms().add(rotateY);
                    DrawingPane.getChildren().add(shape);
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
                    rotateY.setAngle((rotateY.getAngle()-diff));
                //step3DModel.rotationWinkelY(diff);
                    xPos = getMouseX(event);
                    diff = getMouseY(event) - yPos;
                    rotateX.setAngle((rotateX.getAngle()+diff));
                //step3DModel.rotationWinkelX(-diff);
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
        logger.log(Level.WARNING,"Close Window");
    }
}
