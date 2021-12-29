package app;

import app.controller.Controller;
import backend.Engine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();

        Engine engine = new Engine();
        controller.setEngine(engine);
        engine.nextEpoch();
        controller.addSliderListener();

        Scene scene = new Scene(root, 1020, 620);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());

        stage.setTitle("Drone Simulation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
