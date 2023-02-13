import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

public class DrawArea extends JPanel implements MouseListener {
    private final ArrayList<Draw> observers;
    private boolean line;
    private boolean cluster;

    DrawArea() {
        addMouseListener(this);
        this.observers = new ArrayList<>();
        this.line = false;
        this.cluster = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Collections.reverse(observers);
        for(Draw drawing : observers) {
            drawing.draw(g);
        }
    }

    public void setLine() {
        observers.removeIf(drawing -> drawing instanceof Line);
        line = !line;
    }

    public void setCluster() {
        cluster = !cluster;
        for(Draw drawing : observers) {
            if(drawing instanceof Dot) {
                drawing.updateCluster(0, 0);
            }
        }
    }

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
