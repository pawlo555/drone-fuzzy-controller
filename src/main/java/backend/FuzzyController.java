package backend;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class FuzzyController {
    private final static String X_SPEED = "total_x_speed";
    private final static String X_POSITION = "drone_x_position";
    private final static String X_ACCELERATION = "drone_x_acc";

    private final static String Y_SPEED = "total_y_speed";
    private final static String Y_POSITION = "drone_y_position";
    private final static String Y_ACCELERATION = "drone_y_acc";

    private final FIS fis;

    public FuzzyController() {
        String fileName = getClass().getResource("controller.fcl").getFile();
        fis = FIS.load(fileName, false);

        plotCharts();
    }

    public Vector2D getAcceleration(Vector2D totalSpeed, Vector2D position) {
        fis.setVariable(X_SPEED, totalSpeed.x);
        fis.setVariable(X_POSITION, position.x);

        fis.setVariable(Y_SPEED, totalSpeed.y);
        fis.setVariable(Y_POSITION, position.y);

        fis.evaluate();

        double x_acceleration = fis.getVariable(X_ACCELERATION).getValue();
        double y_acceleration = fis.getVariable(Y_ACCELERATION).getValue();
        return new Vector2D(x_acceleration,y_acceleration);
    }

    public void plotCharts() {
        JFuzzyChart.get().chart(fis);
    }
}
