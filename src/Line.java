import java.awt.*;
import java.awt.geom.Line2D;

/**
 * The line class that draws and holds information about the line.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */

public class Line extends Draw {
    /**
     * Constructor for the line class
     *
     * @param x1        The x first coordinate of the drawing.
     * @param y1        The y first coordinate of the drawing.
     * @param x2        The x second coordinate of the drawing.
     * @param y2        The y second coordinate of the drawing.
     *
     **/
    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2, Color.BLACK);
    }

    /**
     * Draws the line.
     *
     * @param g     Holds the graphics info to draw.
     *
     **/
    @Override
    void draw(Graphics g) {
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(new Line2D.Float(x1, y1, x2, y2));
    }

    /**
     * Does not work for the line class.
     *
     * @param dot   Holds the dot but does nothing.
     * @return      Returns nothing.
     *
     **/
    @Override
    Line updateLine(Draw dot) {
        return null;
    }

    /**
     * Does nothing
     *
     * @param width     Holds the width of the JPanel.
     * @param height    Holds the height of the JPanel.
     *
     **/
    @Override
    void updateCluster(int width, int height) {

    }
}
