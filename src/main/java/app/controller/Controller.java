package app.controller;

import backend.Drone;
import backend.Engine;
import backend.EngineObserver;
import backend.Wind;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

public class Controller implements EngineObserver {
    private final Image arrowImage;

    @FXML private Slider windSpeedChangeProbabilitySlider;
    @FXML private Slider windDirectionChangeProbabilitySlider;

    @FXML private ImageView windSpeedImageView;
    @FXML private ImageView droneSpeedImageView;
    @FXML private ImageView droneAccelerationImageView;
    @FXML private Label windSpeedLabel;
    @FXML private Label droneSpeedLabel;
    @FXML private Label droneAccelerationLabel;


    private Engine engine;

    public Controller() {
        arrowImage = new Image(getClass().getResource("arrow.png").toString(), 50, 50, false, false);

    }

    public void addSliderListener() {
        windSpeedChangeProbabilitySlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> windSpeedChangeProbabilityChanged());
        windDirectionChangeProbabilitySlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> windDirectionChangeProbabilityChanged());
    }

    public void nextEpoch() {
        paintImageViews();
        updateInfoLabels();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
        engine.addObserver(this);
    }

    private void paintImageViews() {
        paintWindSpeedView();
        paintDroneSpeedView();
        paintDroneAccelerationView();
    }

    private void paintDroneAccelerationView() {
        Drone drone = engine.getDrone();
        paintImageView(droneAccelerationImageView, drone.getAccelerationAngle().getAngle());
    }

    private void paintDroneSpeedView() {
        Drone drone = engine.getDrone();
        paintImageView(droneSpeedImageView, drone.getSpeedAngle().getAngle());
    }

    private void paintWindSpeedView() {
        Wind wind = engine.getWind();
        paintImageView(windSpeedImageView, wind.getAngle().getAngle());
    }

    private void updateInfoLabels() {
        updateInfoWindSpeed();
        updateInfoDroneSpeed();
        updateInfoDroneAcceleration();
    }

    private void updateInfoDroneAcceleration() {
        Drone drone = engine.getDrone();
        updateInfoLabels(droneAccelerationLabel, drone.getAcceleration(), drone.getAccelerationAngle().getAngle());
    }

    private void updateInfoDroneSpeed() {
        Drone drone = engine.getDrone();
        updateInfoLabels(droneSpeedLabel, drone.getSpeed(), drone.getSpeedAngle().getAngle());
    }

    private void updateInfoWindSpeed() {
        Wind wind = engine.getWind();
        updateInfoLabels(windSpeedLabel, wind.getValue(), wind.getAngle().getAngle());
    }

    public void startSimulation() {
        engine.start();
        engine.nextEpoch();
    }

    private void paintImageView(ImageView imageView, int angle) {
        imageView.setImage(arrowImage);
    }

    private void updateInfoLabels(Label label, double value, int angle) {
        System.out.println("JANusz");
        System.out.println(value);
        DecimalFormat df = new DecimalFormat("00.00");
        System.out.println(df.format(value));
        String angleValue = String.format("%03d", angle);
        label.setText("Value: " + df.format(value) + " direction: " + angleValue);
    }

    @FXML private void windSpeedChangeProbabilityChanged() {
        System.out.println("Janusz");
    }

    @FXML private void windDirectionChangeProbabilityChanged() {

    }
}
