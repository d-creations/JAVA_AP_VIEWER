package ch.dcreations.apviewer.gui;

import ch.rcreations.stepdecoder.Step3DModel;
import ch.rcreations.stepdecoder.StepShapes.StepShapes;
import ch.rcreations.stepdecoder.StepShapes.StepText;
import ch.dcreations.apviewer.config.LogConfiguration;
import ch.dcreations.apviewer.fileHandler.FileHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    Boolean turn = false;

    @FXML
    private AnchorPane DrawingPane;
    @FXML
    private ListView<String> propertyViewList;
    @FXML
    private AnchorPane ProjectPane;
    @FXML
    private TreeView<StepShapes> treeView;
    @FXML
    private AnchorPane PropertiesPane;

    private Group subGroup;
    private Camera camera;
    private Group SelectedAPItem = new Group();

    @FXML
    void initialize() {
        viewModel = new ViewModel();
        propertyViewList.setEditable(true);
        propertyViewList.setItems(viewModel.list);
        viewModel.setList(new ArrayList<>());
        // Model on change Listener
        viewModel.addPropertyChangeListener(evt -> {

            for (Step3DModel step3DModel1 : viewModel.step3DModels) {
                for (MeshView shape : step3DModel1.getShapes2DMesh()) {

                    //shape.setDrawMode(DrawMode.FILL ); // Rotation not good wenn on
                    shape.setCache(true);
                    SelectedAPItem.setCache(true);
                    shape.setCacheHint(CacheHint.ROTATE);
                    SelectedAPItem.setCacheHint(CacheHint.ROTATE);
                    SelectedAPItem.setTranslateX(150);
                    SelectedAPItem.setTranslateY(150);
                    shape.setTranslateX(150);
                    shape.setTranslateY(150);
                    shape.setMaterial(new PhongMaterial(Color.CORNFLOWERBLUE));
                    shape.setCullFace(CullFace.BACK);
                    shape.getTransforms().add(new Scale(2, 2));
                    SelectedAPItem.getTransforms().add(new Scale(2, 2));
                    rotateX.setAxis(new Point3D(1, 0, 0));
                    rotateY.setAxis(new Point3D(0, 1, 0));
                    shape.getTransforms().add(rotateX);
                    SelectedAPItem.getTransforms().add(rotateX);
                    SelectedAPItem.getTransforms().add(rotateY);
                    shape.getTransforms().add(rotateY);
                    subGroup.getChildren().add(shape);
                    subGroup.getChildren().add(SelectedAPItem);
                    TreeItem<StepShapes> treeItem = new TreeItem<>(new StepText("Project"));
                    treeItem.getChildren().add(step3DModel1.getStepShapes());
                    treeView.setCache(true);
                    treeView.setEditable(true);
                    treeView.setRoot(treeItem);

                }
            }
        });
    }



    public void setStage(Stage stage, Group subPane) {
        this.stage = stage;
        this.subGroup = subPane;
    }

    @FXML
    void treeViewItemSelected(MouseEvent event) {
        if (treeView.getSelectionModel().getSelectedItem() != null) {
            TreeItem<StepShapes> treeItem = treeView.getSelectionModel().getSelectedItem();
            List<String> text = new ArrayList<>();
            if (treeItem.getValue().getTyp()!= null) {
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
                if (treeItem.getValue().getShape() != null){
                    SelectedAPItem.getChildren().clear();
                    SelectedAPItem.getChildren().add(treeItem.getValue().getShape());
                }else {
                    SelectedAPItem.getChildren().clear();
                }
            }
            viewModel.setList(text);
        }
    }
    @FXML
    private void selectAFile() throws IOException {
        closeFile();
        step3DModel = new Step3DModel("");
        if (stage == null) {
            logger.log(Level.WARNING, "stage null");
        } else {
            try {
                fileHandler = new FileHandler(stage, step3DModel);
            } catch (IOException e) {
                throw new IOException("file not found");
            }
            fileHandler.getAFile();
            step3DModel.setName(fileHandler.getFileName());
        }
        viewModel.addStepModel(step3DModel);

    }
    @FXML
    void closeFile() {
        SelectedAPItem.getChildren().clear();
        subGroup.getChildren().clear();
        viewModel.clearStepModel();
        treeView.setRoot(null);

    }

    @FXML
    private void mouseHandler(MouseEvent event) {

        if (turn) {
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
        turn=true;
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
        subScene. setWidth(DrawingPane.getMaxWidth());
        subScene.setHeight(DrawingPane.getMaxWidth());
        DrawingPane.getChildren().add(subScene);
        final PerspectiveCamera camera = new PerspectiveCamera();
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-100);
        subScene.setCamera(camera);
    }
}
