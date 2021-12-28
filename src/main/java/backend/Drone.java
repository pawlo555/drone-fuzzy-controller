package backend;

import app.elements.Visualizer;

public class Drone {
    private static final double DELTA_T = 0.1;
    private static final double MAX_SPEED = 5;

    private Vector2D speed = new Vector2D(0.1, 0.3);
    private Vector2D acceleration = new Vector2D(0,0);
    private Vector2D position = new Vector2D(Visualizer.CENTER_POSITION);

    private final FuzzyController fuzzyController = new FuzzyController();

    public double getSpeed() {
        return speed.vectorLength();
    }

    public Angle getSpeedAngle() {
        return speed.vectorAngle();
    }

    public double getAcceleration() {
        return acceleration.vectorLength();
    }

    public Angle getAccelerationAngle() {
        return acceleration.vectorAngle();
    }

    public Vector2D getPosition() {
        return position;
    }

    public void nextEpoch() {
        acceleration = fuzzyController.getAcceleration();
        updateSpeed();
    }

    public void updateSpeed() {
        speed = speed.add(acceleration.multiply(DELTA_T));
    }

    public void updatePosition(Wind wind) {
        Vector2D windSpeed = wind.getAngle().toUnitVector().multiply(wind.getValue());
        System.out.println(windSpeed);
        Vector2D totalSpeed = windSpeed.add(speed);
        position = position.add(totalSpeed.multiply(DELTA_T));
    }

}
