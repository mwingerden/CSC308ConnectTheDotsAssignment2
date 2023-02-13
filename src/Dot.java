import java.awt.*;

/**
 * The Dot that extends the Draw class. Holds implementation that draws the dot and has update methods that creates a
 * line and changes the color.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */

public class Dot extends Draw {

    /**
     * Constructor for the dot.
     *
     * @param x     The x coordinate for the dot.
     * @param y     The y coordinate for the dot.
     *
     **/
    public Dot(int x, int y) {
        super(x, y, Color.BLACK);
    }

    /**
     * Draws the dot with respective x and y coordinate;
     *
     * @param g     Holds the graphics class in order draw the drawing.
     *
     **/
    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1 -4, y1 -4, 10,10);
    }

    /**
     * Takes the coordinate of the current dot and the coordinates of the second dot to return the
     * coordinates of the line.
     *
     * @param dot   The second dot to draw the line
     * @return      Returns a new line created with the two pair of coordinates.
     *
     **/
    public Line updateLine(Draw dot) {
        return new Line(this.x1, this.y1, dot.getX1(), dot.getY1());
    }

    /**
     * Takes the width of height of the size of the JPanel and compares it against the coordinate pair (0,0) to see
     * if the current dot is closer to either. If the dot is closer to (0,0) then it will change the color to cyan,
     * otherwise the color will change to orange.
     *
     * @param width   The current width of the JPanel.
     * @param height  The current height of the JPanel.
     *
     **/
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
