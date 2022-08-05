package ch.dcreations.apviewer.gui;

import ch.dcreations.apviewer.config.Print;
import ch.rcreations.stepdecoder.Step3DModel;
import ch.rcreations.stepdecoder.StepShapes.StepShapes;
import ch.rcreations.stepdecoder.StepShapes.StepText;
import ch.dcreations.apviewer.config.LogConfiguration;
import ch.dcreations.apviewer.fileHandler.FileHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * <p>
 *  Print function that can be set do DEBUG
 * <p>
 *
 * @author Damian www.d-creations.org
 * @version 1.0
 * @since 2022-08-03
 */

public class mainViewController {

    private static final Logger logger = Logger.getLogger(LogConfiguration.class.getCanonicalName());
    double xPos = 0;
    double yPos = 0;
    ViewModel viewModel;
    Rotate rotateX = new Rotate();
    Rotate rotateY = new Rotate();
    FileHandler fileHandler;
    Step3DModel step3DModel;
    Stage stage;


    @FXML
    private TreeView<StepShapes> treeView;

    @FXML
    private SubScene view3D;

    @FXML
    private AnchorPane DrawingPane;

    @FXML
    private ListView<String> propertyViewList;


    @FXML
    private TabPane tabPane;

    @FXML
    private TextArea textArea;

    @FXML
    private Group subGroup;
    private Group SelectedAPItem = new Group();
    private Scale scale = new Scale();

    Translate translate = new Translate();
    MouseFunction mouseFunction = MouseFunction.DEFAULT;

    @FXML
    void initialize() {
        viewModel = new ViewModel();
        propertyViewList.setEditable(true);
        propertyViewList.setItems(viewModel.list);
        viewModel.setList(new ArrayList<>());
        view3D.widthProperty().bind(tabPane.widthProperty());
        view3D.heightProperty().bind(tabPane.heightProperty());
        final PerspectiveCamera camera = new PerspectiveCamera();
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-100);
        view3D.setCamera(camera);


        // Model on change Listener
        viewModel.addPropertyChangeListener(evt -> {
            SelectedAPItem.getTransforms().add(scale);
            rotateX.setAxis(new Point3D(1, 0, 0));
            rotateY.setAxis(new Point3D(0, 1, 0));
            rotateY.setAngle(0);
            rotateX.setAngle(0);
            for (Step3DModel step3DModel1 : viewModel.step3DModels) {
                TreeItem<StepShapes> treeItem = new TreeItem<>(new StepText("Project"));
                treeView.setCache(true);
                treeView.setEditable(true);
                treeView.setRoot(treeItem);
                treeItem.getChildren().add(step3DModel1.getStepShapes());
                for (MeshView shape : step3DModel1.getShapes2DMesh()) {
                    shape.setDrawMode(DrawMode.FILL); // Rotation not good wenn on
                    shape.setCache(true);
                    reCenter();
                    SelectedAPItem.setCache(true);
                    shape.setCacheHint(CacheHint.ROTATE);
                    SelectedAPItem.setCacheHint(CacheHint.ROTATE);
                    shape.setMaterial(new PhongMaterial(Color.CORNFLOWERBLUE));
                    shape.setCullFace(CullFace.BACK);
                    shape.getTransforms().add(scale);
                    shape.getTransforms().add(translate);
                    SelectedAPItem.getTransforms().add(translate);
                    shape.getTransforms().add(rotateX);
                    shape.getTransforms().add(rotateY);
                    SelectedAPItem.getTransforms().add(rotateX);
                    SelectedAPItem.getTransforms().add(rotateY);
                    subGroup.getChildren().add(shape);
                    subGroup.getChildren().add(SelectedAPItem);

                }
            }
        });
    }


    public void setStage(Stage stage, Group group) {
        this.stage = stage;
        this.subGroup = group;
        view3D.setRoot(subGroup);
    }

    @FXML
    void treeViewItemSelected(MouseEvent event) {
        if (treeView.getSelectionModel().getSelectedItem() != null) {
            TreeItem<StepShapes> treeItem = treeView.getSelectionModel().getSelectedItem();
            List<String> text = new ArrayList<>();
            if (treeItem.getValue().getTyp() != null) {
                if (treeItem.getValue().getPreferencesList() != null) {
                    for (Map<String, String> preferencesMapList : treeItem.getValue().getPreferencesList()) {
                        if (preferencesMapList != null) {
                            for (String key : preferencesMapList.keySet()) {
                                text.add(key);
                                text.add(preferencesMapList.get(key));
                            }
                        }
                    }
                }
                if (treeItem.getValue().getShape() != null) {
                    SelectedAPItem.getChildren().clear();
                    SelectedAPItem.getChildren().add(treeItem.getValue().getShape());
                } else {
                    SelectedAPItem.getChildren().clear();
                }
            }

            viewModel.setList(text);
        }
    }

    @FXML
    private void selectAFile() {
        closeFile();
        step3DModel = new Step3DModel("");
        if (stage == null) {
            logger.log(Level.WARNING, "stage null");
        } else {
            try {
                fileHandler = new FileHandler(stage, step3DModel);
                fileHandler.getAFile();
                step3DModel.setName(fileHandler.getFileName());
                viewModel.setTextField(fileHandler.readText());
                viewModel.addStepModel(step3DModel);
                textArea.setText(viewModel.getText());
            } catch (IOException e) {
                Print.printMessage("File Not Found"); // Print.printError
            }
        }
    }

    @FXML
    void closeFile() {
        SelectedAPItem.getChildren().clear();
        subGroup.getChildren().clear();
        viewModel.clearStepModel();
        treeView.setRoot(null);
        viewModel.setTextField("");
        textArea.setText(viewModel.getText());

    }

    @FXML
    void zoomIn() {
        scale.setX(scale.getX() * 1.5);
        scale.setY(scale.getY() * 1.5);
        scale.setZ(scale.getZ() * 1.5);
        translate.setX(translate.getX() * 0.5);
        translate.setY(translate.getY() * 0.5);
        translate.setZ(translate.getZ() * 0.5);
    }

    @FXML
    void zoomOut() {
        scale.setX(scale.getX() * 0.75);
        scale.setY(scale.getY() * 0.75);
        scale.setZ(scale.getZ() * 0.75);
        translate.setX(translate.getX() * 1.5);
        translate.setY(translate.getY() * 1.5);
        translate.setZ(translate.getZ() * 1.5);
    }

    @FXML
    void saveToNewFile() {
        try {
            viewModel.setTextField(textArea.getText());
            FileHandler fileToSave = new FileHandler(stage, step3DModel);
            fileToSave.saveToNewFile(viewModel.getText());
        } catch (Exception e) {
            Print.printError(e.getMessage());
        }

    }

    @FXML
    void saveAndLoad() {
        try {
            Print.printMessage("Save an load");
            reCenter();
            viewModel.setTextField(textArea.getText());
            Step3DModel step3DModel1 = fileHandler.saveToFile(viewModel.getText());
            closeFile();
            viewModel.addStepModel(step3DModel1);
            viewModel.setTextField(fileHandler.readText());
            textArea.setText(viewModel.getText());
        } catch (Exception e) {
            Print.printError(e.getMessage());
        }

    }


    @FXML
    void reCenter() {
        rotateX.setAngle(0);
        rotateY.setAngle(0);
        double middleWidthOfScene = DrawingPane.getWidth() / 4;
        double middleHighOfScene = DrawingPane.getHeight() / 4;
        scale.setX(2);
        scale.setY(2);
        scale.setZ(2);
        translate.setX(middleWidthOfScene);
        translate.setY(middleHighOfScene);
    }

    @FXML
    private void mouseHandler(MouseEvent event) {

        switch (mouseFunction) {
            case TURN -> {
                double diff = getMouseX(event) - xPos;
                rotateY.setAngle((rotateY.getAngle() - diff));
                xPos = getMouseX(event);
                diff = getMouseY(event) - yPos;
                rotateX.setAngle((rotateX.getAngle() + diff));
                yPos = getMouseY(event);
            }
            case MOVE -> {
                double diff = getMouseX(event) - xPos;
                translate.setX(translate.getX() + (diff / 2));
                xPos = getMouseX(event);
                diff = getMouseY(event) - yPos;
                translate.setY(translate.getY() + (diff / 2));
                yPos = getMouseY(event);
            }
        }
        Print.printMessage(mouseFunction.name());


    }

    @FXML
    private void mouseReleased(MouseEvent event) {
        Print.printMessage("Mouse released");
        mouseFunction = MouseFunction.DEFAULT;
    }

    @FXML
    private void mousePressed(MouseEvent event) {
        Print.printMessage("Mouse Pressed");
        xPos = getMouseX(event);
        yPos = getMouseY(event);
        switch (event.getButton()) {
            case PRIMARY -> mouseFunction = MouseFunction.TURN;
            case SECONDARY -> mouseFunction = MouseFunction.MOVE;

        }
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
}
