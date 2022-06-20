package ch.dcreations.apviewer.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
            // fill in scene and stage setup
            Scene scene = new Scene(rootPane);
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
