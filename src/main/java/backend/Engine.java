package backend;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class Engine {
    private final static int milliSeconds = 1000/60;

    private final Wind wind = new Wind();
    private final Drone drone = new Drone();

    private final Timeline timeline;

    ArrayList<EngineObserver> engineObservers = new ArrayList<>();

    public Engine() {
        timeline = new Timeline(new KeyFrame(
                Duration.millis(milliSeconds),
                ae -> this.nextEpoch()));
        timeline.stop();
        timeline.setCycleCount(Animation.INDEFINITE);
    }


    public void nextEpoch() {
        wind.nextEpoch();
        drone.nextEpoch(wind);
        drone.updatePosition(wind);
        notifyObservers();
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    public void addObserver(EngineObserver observer) {
        engineObservers.add(observer);
    }

    private void notifyObservers() {
        engineObservers.forEach(EngineObserver::nextEpoch);
    }

    public Wind getWind() {
        return wind;
    }

    public Drone getDrone() {
        return drone;
    }
}
