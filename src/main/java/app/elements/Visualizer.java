package app.elements;

import backend.Drone;
import backend.Vector2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Visualizer extends Canvas {
    private final static int SIZE = 600;
    private final static int SHORT_SIZE = 50;
    private final static int MEDIUM_SIZE = 100;
    private final static int LONG_SIZE = 150;
    private final static int DRONE_SIZE = 40;


    private final Image droneImage;

    public Visualizer() {
        super(SIZE, SIZE);
        droneImage = new Image(getClass().getResource("drone.png").toString(), DRONE_SIZE, DRONE_SIZE, false, false);
        paintBackGround();
    }

    private void paintBackGround() {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, SIZE, SIZE);
        gc.setFill(Color.YELLOW);
        gc.fillOval(SIZE/2.0-LONG_SIZE, SIZE/2.-LONG_SIZE, LONG_SIZE*2, LONG_SIZE*2);

        gc.setFill(Color.ORANGE);
        gc.fillOval(SIZE/2.0-MEDIUM_SIZE, SIZE/2.-MEDIUM_SIZE, MEDIUM_SIZE*2, MEDIUM_SIZE*2);

        gc.setFill(Color.RED);
        gc.fillOval(SIZE/2.0-SHORT_SIZE, SIZE/2.-SHORT_SIZE, SHORT_SIZE*2, SHORT_SIZE*2);
    }

    private void paintDrone(Drone drone) {
        Vector2D position = toVisualizerPosition(drone.getPosition());
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.drawImage(droneImage, position.x-DRONE_SIZE/2., position.y-DRONE_SIZE/2.);
    }

    public void repaint(Drone drone) {
        paintBackGround();
        paintDrone(drone);
    }

    public Vector2D toVisualizerPosition(Vector2D position) {
        return new Vector2D(position.x+SIZE/2., position.y+SIZE/2.);
    }
}
