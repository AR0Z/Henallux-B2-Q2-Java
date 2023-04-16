package series4;

import java.awt.*;

public class Wall {
    private final Rectangle rectangle;
    private final int point;

    public Wall(int height, int width, int x, int y, int point) {
        rectangle = new Rectangle(x, y, width, height);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void draw(Graphics g) {
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public boolean collision(Ball ball) {
        return rectangle.intersects(ball.getRectangle());
    }
}
