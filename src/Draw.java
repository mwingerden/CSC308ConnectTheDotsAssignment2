import java.awt.*;

/**
 * The Draw abstract class holds the coordinates for the drawings and has a couple of abstract methods for subclass
 * the implement.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */

public abstract class Draw {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected Color color;

    /**
     * The constructor that takes only an x y coordinate and a color. Specifically made for the dot subclass.
     *
     * @param x1        The x coordinate of the drawing.
     * @param y1        The y coordinate of the drawing.
     * @param color     The color of the drawing.
     *
     **/
    public Draw(int x1, int y1, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }

    /**
     * The constructor that takes only 2 pairs of x y coordinate and a color. Specifically made for the line subclass.
     *
     * @param x1        The first x coordinate of the drawing.
     * @param y1        The first y coordinate of the drawing.
     * @param x2        THe second x coordinate of the drawing.
     * @param y2        The second y coordinate of the drawing.
     * @param color     The color of the drawing.
     *
     **/
    public Draw(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * Abstract method to be implemented in subclass.
     *
     * @param g     Holds the graphics class do draw the drawing.
     *
     **/
    abstract void draw(Graphics g);

    /**
     * Abstract method to be implemented in subclass.
     *
     * @param dot     The second dot that holds the second coordinates to create a line.
     * @return        The new Line.
     *
     **/
    abstract Line updateLine(Draw dot);

    /**
     * Abstract method to be implemented in subclass.
     *
     * @param width     The width of the JPanel
     * @param height    The height of the JPanel.
     *
     **/
    abstract void updateCluster(int width, int height);

    /**
     * Returns the first x coordinate.
     *
     * @return      Returns the first x coordinate.
     *
     **/
    public int getX1() {
        return x1;
    }

    /**
     * Returns the first y coordinate.
     *
     * @return      Returns the first y coordinate.
     *
     **/
    public int getY1() {
        return y1;
    }
}
