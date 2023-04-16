package series4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Billiard extends JPanel {
    private final ArrayList<Wall> verticalWallsArray;
    private final ArrayList<Wall> horizontalWallsArray;
    private final ArrayList<Ball> ballsArray;
    private final List<Ball> balls;
    private final ArrayList<Hole> holesArray;

    private int totalPoints;

    public Billiard() {

        horizontalWallsArray = new ArrayList<Wall>();
        verticalWallsArray = new ArrayList<Wall>();
        ballsArray = new ArrayList<Ball>();
        holesArray = new ArrayList<Hole>();
        balls = Collections.synchronizedList(ballsArray);

        horizontalWallsArray.add(new Wall(5, 265, 10, 10, 0));
        horizontalWallsArray.add(new Wall(5, 265, 10, 505, 0));

        verticalWallsArray.add(new Wall(500, 5, 10, 10, 0));
        verticalWallsArray.add(new Wall(500, 5, 270, 10, 0));

        verticalWallsArray.add(new Wall(150, 3, 100, 55, 10));
        horizontalWallsArray.add(new Wall(3, 3, 100, 54, 20));
        horizontalWallsArray.add(new Wall(3, 3, 100, 205, 20));

        horizontalWallsArray.add(new Wall(3, 120, 40, 300, 40));
        verticalWallsArray.add(new Wall(3, 3, 39, 300, 50));
        verticalWallsArray.add(new Wall(3, 3, 160, 300, 50));

        holesArray.add(new Hole(15, 15, 150, 200));

        holesArray.add(new Hole(15, 15, 34, 456));

        ballsArray.add(new Ball(this, 10, 10, 200, 450));

        MovementThread movementThread = new MovementThread(this);
        movementThread.start();

        ColorChangingThread colorChangingThread = new ColorChangingThread(this);
        colorChangingThread.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        verticalWallsArray.forEach(wall -> {
            wall.draw(g);
        });

        horizontalWallsArray.forEach(wall -> wall.draw(g));

        balls.forEach(ball -> ball.draw(g));

        holesArray.forEach(hole -> hole.draw(g));
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public ArrayList<Wall> getHorizontalWallsArray() {
        return horizontalWallsArray;
    }

    public ArrayList<Wall> getVerticalWallsArray() {
        return verticalWallsArray;
    }

    public ArrayList<Hole> getHolesArray() {
        return holesArray;
    }

    public void addPoint(int point) {
        totalPoints += point;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
