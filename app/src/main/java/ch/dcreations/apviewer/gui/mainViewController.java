package ch.dcreations.apviewer.gui;

import ch.dcreations.apviewer.Step3DModel.Step3DModel;
import ch.dcreations.apviewer.config.LogConfiguration;
import ch.dcreations.apviewer.fileHandler.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainViewController {

    private static final Logger logger = Logger.getLogger(LogConfiguration.class.getCanonicalName());

    ViewModel viewModel;
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
                for (Shape shape : step3DModel1.getShapes2D()) {
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



    public void closeController() {
        logger.log(Level.WARNING,"Close Window");
    }
}
