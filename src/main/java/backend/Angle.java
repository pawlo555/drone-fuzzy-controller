package backend;

public class Angle {
    public static final int MAX_DEGREES = 360;

    private int angle;

    public Angle() {
        angle = 0;
    }

    public Angle(int angle) {
        this.angle = (angle+MAX_DEGREES)%MAX_DEGREES;
    }

    private void rotate(int toRotate) {
        angle = (angle+toRotate+MAX_DEGREES)%MAX_DEGREES;
    }

    public int getAngle() {
        return angle;
    }
}
