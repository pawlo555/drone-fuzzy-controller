package backend;

public class Vector2D {
    public final double x;
    public final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D second) {
        return new Vector2D(this.x+ second.x, this.y + second.y);
    }

    public Vector2D multiply(double x) {
        return new Vector2D(this.x*x, this.y*x);
    }

    public double vectorLength() {
        return Math.sqrt(x*x+y*y);
    }

    public Angle vectorAngle() {
        return new Angle((int)(Math.atan2(y, x)*180/Math.PI));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
