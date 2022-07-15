package ch.dcreations.apviewer.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI_run extends Application {

    mainViewController controller;
    @Override

    public void start(Stage primaryStage) {
        firstwindow(primaryStage);
    }

    private void firstwindow(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("mainView.fxml"));

            Pane rootPane = loader.load();
            //SubScene subScene = new SubScene(rootPane, 800, 800, true, SceneAntialiasing.BALANCED);
            //rootPane.getChildren().add( subScene);
            // fill in scene and stage setup
            Scene scene = new Scene(rootPane,500,500,true);


            final PerspectiveCamera camera = new PerspectiveCamera(true);
            final double cameraDistance = 450;
            camera.setTranslateZ(-cameraDistance);
            //.setCamera(camera);
            // configure and show stage
            primaryStage.setScene(scene);
            controller = loader.getController();
            controller.setStage(primaryStage);
            primaryStage.setOnCloseRequest(event -> controller.closeController());
            primaryStage.setTitle("Draw The Star");
            primaryStage.setResizable(false);

            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error starting up UI " + e.getMessage() + e.toString());
        }
    }
}
