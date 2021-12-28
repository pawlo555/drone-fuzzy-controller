package backend;

public class Wind {

    private double value = 1./3;
    private final Angle angle = new Angle();

    private final Changer windSpeedChanger = new Changer(1);
    private final Changer windDirectionChanger = new Changer(4);

    public void nextEpoch() {
        double speedChange = windSpeedChanger.getChangeValue();
        int directionChanger = (int) Math.round(windDirectionChanger.getChangeValue());

        value = value + speedChange;
        angle.rotate(directionChanger);
    }

    public Angle getAngle() {
        return angle;
    }

    public double getValue() {
        return value;
    }

    public void updateWindSpeechChanger(double newProbability) {
        windSpeedChanger.updateProbability(newProbability);
    }

    public void updateDirectionChanger(double newProbability) {
        windDirectionChanger.updateProbability(newProbability);
    }
}
