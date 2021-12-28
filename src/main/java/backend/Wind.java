package backend;

public class Wind {

    private double value = 1./3;
    private Angle angle = new Angle();


    public Wind() {

    }

    public Angle getAngle() {
        return angle;
    }

    public double getValue() {
        System.out.println(value);
        return value;
    }
}
