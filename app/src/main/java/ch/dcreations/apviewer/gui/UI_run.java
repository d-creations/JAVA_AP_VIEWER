package ch.dcreations.apviewer.gui;

import ch.dcreations.apviewer.config.Print;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * <p>
 * <p>
 *  Userinterface contains the Controller and the View Loader
 * <p>
 *
 * @author Damian www.d-creations.org
 * @version 1.0
 * @since 2022-08-03
 */
public class UI_run extends Application {

    mainViewController controller;
    @Override

    public void start(Stage primaryStage) {
        firstWindow(primaryStage);
    }

    private void firstWindow(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("mainView.fxml"));
            Pane rootPane = loader.load();
            Scene scene = new Scene(rootPane, 1000, 600, true);
            Group subPane = new Group();
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.setMinHeight(300);
            primaryStage.setMinWidth(600);
            controller = loader.getController();
            controller.setStage(primaryStage,subPane);
            primaryStage.setOnCloseRequest(event -> controller.closeController());
            primaryStage.setTitle("AP-Viewer");
            primaryStage.show();
        } catch (Exception e) {
            Print.printError("Error starting up UI " + e.getMessage() + e);
        }
    }
}
