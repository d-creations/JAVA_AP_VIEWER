package ch.dcreations.apviewer.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
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
            Scene scene = new Scene(rootPane,1000,600,true);

            Group subPane = new Group();
            SubScene subScene = new SubScene(subPane, 0, 0, true,SceneAntialiasing.DISABLED);
            subScene.autosize();
            ;
            subScene.setFill(Color.CADETBLUE);

            // fill in scene and stage setup
            primaryStage.setScene(scene);

            primaryStage.setResizable(true);
            //primaryStage.setMaximized(true);
            primaryStage.setMinHeight(300);
            primaryStage.setMinWidth(600);
            controller = loader.getController();
            controller.setStage(primaryStage,subPane);
            primaryStage.setOnCloseRequest(event -> controller.closeController());
            primaryStage.setTitle("Draw The Star");
            primaryStage.show();
            controller.addSubScene(subScene);
        } catch (Exception e) {
            System.err.println("Error starting up UI " + e.getMessage() + e.toString());
        }
    }
}
