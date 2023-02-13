import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Draw {
    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2, Color.BLACK);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(new Line2D.Float(x1, y1, x2, y2));
    }

    @Override
    Line updateLine(Draw dot) {
        return null;
    }

    @Override
    void updateCluster(int width, int height) {

    }
}
