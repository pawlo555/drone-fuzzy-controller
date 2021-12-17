package app.controller;

import app.elements.Indicator;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class Controller {

    @FXML private Slider windSpeedChangeProbabilitySlider;
    @FXML private Slider windDirectionChangeProbabilitySlider;

    @FXML private Indicator windSpeedIndicator;
    @FXML private Indicator droneSpeedIndicator;
    @FXML private Indicator droneAccelerationIndicator;
}
