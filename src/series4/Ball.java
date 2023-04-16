package series4;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ball {
    private final Billiard billiard;
    private final Rectangle rectangle;
    private int stepX = 1;
    private int stepY = 1;
    private Color color;
    private boolean toEliminate;

    public static ArrayList<Color> listColor = new ArrayList<>() {{
        add(Color.red);
        add(Color.orange);
        add(Color.yellow);
        add(Color.green);
        add(Color.blue);
        add(Color.magenta);
    }};

    public Ball(Billiard billiard, int height, int width, int x, int y) {
        this.billiard = billiard;
        rectangle = new Rectangle(x, y, width, height);
        color = Color.black;
        toEliminate = false;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void draw(Graphics g) {

        int centerX = rectangle.x + rectangle.width / 2;
        int centerY = rectangle.y + rectangle.height / 2;

        int ballRadius = rectangle.width / 2;
        g.setColor(color);
        g.fillOval(centerX - ballRadius, centerY - ballRadius, ballRadius * 2, ballRadius * 2);
        g.setColor(Color.black);

    }

    public void changeColor() {
        int currentIndex = listColor.indexOf(color);

        color = listColor.get(currentIndex != -1 ? (currentIndex + 1 < listColor.size() ? currentIndex + 1 : 0) : 0);
    }

    public boolean collision(Ball ball) {
        return rectangle.intersects(ball.getRectangle());
    }

    public void move() {

        AtomicBoolean modifyAlready = new AtomicBoolean(false);

        billiard.getBalls().forEach(ball -> {
            if (collision(ball) && this != ball) {
                stepX *= -1;
                stepY *= -1;
                modifyAlready.set(true);
            }
        });

        billiard.getVerticalWallsArray().forEach(wall -> {
            if (wall.collision(this) && !modifyAlready.get()) {
                stepX *= -1;
                billiard.addPoint(wall.getPoint());
                modifyAlready.set(true);
            }
        });

        billiard.getHorizontalWallsArray().forEach(wall -> {
            if (wall.collision(this) && !modifyAlready.get()) {
                stepY *= -1;
                billiard.addPoint(wall.getPoint());
            }
        });

        billiard.getHolesArray().forEach(hole -> {
            if (hole.disapperance(this)) {
                toEliminate = true;
            }
        });

        rectangle.x += stepX;
        rectangle.y += stepY;
    }

    public boolean isToEliminate() {
        return toEliminate;
    }
}
