package backend;

public class Drone {
    private static final double DELTA_T = 0.1;

    private Vector2D speed = new Vector2D(0, 0);
    private Vector2D acceleration = new Vector2D(0,0);
    private Vector2D position = new Vector2D(0,0);

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

    public void nextEpoch(Wind wind) {
        acceleration = fuzzyController.getAcceleration(speed.add(wind.getVector()), position);
        updateSpeed();
    }

    public void updateSpeed() {
        speed = speed.add(acceleration.multiply(DELTA_T));
    }

    public void updatePosition(Wind wind) {
        Vector2D windSpeed = wind.getAngle().toUnitVector().multiply(wind.getValue());
        Vector2D totalSpeed = windSpeed.add(speed);
        updatePosition(totalSpeed);
    }

    private void updatePosition(Vector2D totalSpeed) {
        double x = totalSpeed.x;
        double y = totalSpeed.y;
        position = position.add(new Vector2D(x,y).multiply(DELTA_T));
    }
}
