import java.awt.*;

public class Dot extends Draw {

    public Dot(int x, int y) {
        super(x, y, Color.BLACK);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1 -4, y1 -4, 10,10);
    }

    public Line updateLine(Draw dot) {
        return new Line(this.x1, this.y1, dot.getX1(), dot.getY1());
    }

    @Override
    void updateCluster(int width, int height) {
        if(width == 0 && height == 0) {
            color = Color.BLACK;
            return;
        }
        double hypot1 = Math.hypot(x1, y1);
        double hypot2 = Math.hypot(Math.abs(width - x1), Math.abs(height - y1));
        if(hypot1 <= hypot2) {
            color = Color.CYAN;
        }
        else {
            color = Color.ORANGE;
        }
    }
}
