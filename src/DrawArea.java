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

public class DrawArea extends JPanel implements MouseListener {
    private final ArrayList<Draw> observers;
    private boolean line;
    private boolean cluster;

    /**
     * Constructor for the draw area.
     *
     **/
    DrawArea() {
        addMouseListener(this);
        this.observers = new ArrayList<>();
        this.line = false;
        this.cluster = false;
    }

    /**
     * Loops through the observers and calls them to draw.
     *
     * @param g     Holds the graphics class to draw.
     *
     **/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Collections.reverse(observers);
        for(Draw drawing : observers) {
            drawing.draw(g);
        }
    }

    /**
     * Clears the observers of lines and lets the class know if to draw the lines.
     *
     **/
    public void setLine() {
        observers.removeIf(drawing -> drawing instanceof Line);
        line = !line;
    }

    /**
     * Updates the dot observers to change the color based on the update method.
     *
     **/
    public void setCluster() {
        cluster = !cluster;
        for(Draw drawing : observers) {
            if(drawing instanceof Dot) {
                drawing.updateCluster(0, 0);
            }
        }
    }

    /**
     * Runs all the options that the user selected.
     *
     **/
    public void run() {
        if(line) {
            observers.removeIf(drawing -> drawing instanceof Line);
            for(int i = 0; i+1 < observers.size(); i++) {
                if(observers.get(i) instanceof Dot && observers.get(i + 1) instanceof Dot) {
                    observers.add(observers.get(i).updateLine(observers.get(i + 1)));
                }
            }
        }
        if(cluster) {
            for(Draw drawing : observers) {
                if(drawing instanceof Dot) {
                    drawing.updateCluster(getWidth(), getHeight());
                }
            }
        }
        repaint();
    }

    /**
     * Adds a new dot to the observers.
     *
     * @param e     Holds the mouse information.
     *
     **/
    @Override
    public void mouseReleased(MouseEvent e) {
        observers.add(new Dot(e.getX(), e.getY()));
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
