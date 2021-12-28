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

    public void rotate(int toRotate) {
        angle = (angle+toRotate+MAX_DEGREES)%MAX_DEGREES;
    }

    public int getAngle() {
        return angle;
    }

    public Vector2D toUnitVector() {
        double angleInRadians = angle*Math.PI/180;
        return new Vector2D(Math.sin(angleInRadians),Math.cos(angleInRadians-Math.PI));
    }

}
