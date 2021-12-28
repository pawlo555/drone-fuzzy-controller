package backend;

public class Changer {

    private final int maxChange;
    private double changeProbability;

    public Changer(int maxChange) {
        this.maxChange = maxChange;
    }

    public double getChangeValue() {
        double random = Math.random();
        if (random < changeProbability) {
            double changeValue = maxChange - (random/changeProbability*maxChange);
            if (changeValue > maxChange) {
                System.out.println("Change is too big: " + changeValue);
            }
            if (Math.random() < 0.5) {
                changeValue = -changeValue;
            }
            return changeValue;
        }
        else {
            return 0.0;
        }
    }

    public void updateProbability(double newChangeProbability) {
        changeProbability = newChangeProbability;
    }
}
