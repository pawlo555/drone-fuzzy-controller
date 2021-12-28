package backend;

import java.util.ArrayList;

public class Engine {

    private Wind wind = new Wind();
    private Drone drone = new Drone();

    ArrayList<EngineObserver> engineObservers = new ArrayList<>();

    public Engine() {

    }

    public void nextEpoch() {
        notifyObservers();
    }

    public void start() {

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
