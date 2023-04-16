package series4;

import java.awt.*;

public class Hole {
    private final Rectangle rectangle;

    public Hole(int height, int width, int x, int y) {
        rectangle = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {

        int centerX = rectangle.x + rectangle.width / 2;
        int centerY = rectangle.y + rectangle.height / 2;

        int ballRadius = rectangle.width / 2;
        g.fillOval(centerX - ballRadius, centerY - ballRadius, ballRadius * 2, ballRadius * 2);

    }

    public boolean disapperance(Ball ball) {
        return rectangle.intersects(ball.getRectangle());
    }
}
