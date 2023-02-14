import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The DrawArea class is created as a JPanel to hold the drawings and user inputted clicks. Holds all the observables
 * to be updated based on the options of the user.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */

public class DrawArea extends JPanel implements MouseListener, Observer{
    private final ArrayList<Draw> drawings;

    /**
     * Constructor for the draw area.
     *
     **/
    DrawArea() {
        addMouseListener(this);
        this.drawings = new ArrayList<>();
        setOpaque(true);
        setBackground(Color.DARK_GRAY);
    }

    /**
     * An update method from the Observer interface that tells the class what options to draw.
     *
     * @param cluster       Boolean to see if there is a need to draw a cluster.
     * @param connect       Boolean to see if there is a need to draw lines.
     *
     **/
    @Override
    public void update(boolean cluster, boolean connect) {
        clear();
        if(cluster) {
            drawCluster();
        }
        if(connect) {
            drawLine();
        }
        repaint();
    }

    /**
     * Loops through the observers and calls them to draw.
     *
     * @param g     Holds the graphics class to draw.
     *
     **/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Collections.reverse(drawings);
        for(Draw drawing : drawings) {
            drawing.draw(g);
        }
    }

    /**
     * Clears the list of the lines and resets the dots back to the original color.
     *
     **/
    private void clear() {
        drawings.removeIf(drawing -> drawing instanceof Line);
        for(Draw drawing : drawings) {
            if(drawing instanceof Dot) {
                drawing.updateCluster(0, 0);
            }
        }
    }

    /**
     * Adds the lines to be drawn to the class.
     *
     **/
    private void drawLine() {
        for(int i = 0; i+1 < drawings.size(); i++) {
            if(drawings.get(i) instanceof Dot && drawings.get(i + 1) instanceof Dot) {
                drawings.add(drawings.get(i).updateLine(drawings.get(i + 1)));
            }
        }
    }

    /**
     * Updates the dot drawings to change the color based on the update method.
     *
     **/
    private void drawCluster() {
        for(Draw drawing : drawings) {
            if(drawing instanceof Dot) {
                drawing.updateCluster(getWidth(), getHeight());
            }
        }
    }

    /**
     * Adds a new dot to the observers.
     *
     * @param e     Holds the mouse information.
     *
     **/
    @Override
    public void mouseReleased(MouseEvent e) {
        drawings.add(new Dot(e.getX(), e.getY()));
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
