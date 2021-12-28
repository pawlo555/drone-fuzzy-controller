package backend;

public class Drone {
    private static final double DELTA_T = 0.1;

    private double speed = 1./3;
    private Angle speedAngle = new Angle(0);
    private double acceleration = 1./3;
    private Angle accelerationAngle = new Angle(0);
    private Vector2D position = new Vector2D(200, 200);

    public Drone() {

    }

    public double getSpeed() {
        return speed;
    }

    public Angle getSpeedAngle() {
        return speedAngle;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public Angle getAccelerationAngle() {
        return accelerationAngle;
    }

    public void nextEpoch(Wind wind) {

    }

}
