import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawArea extends JPanel implements MouseListener {
    private final ArrayList<Draw> drawings;

    DrawArea() {
        addMouseListener(this);
        drawings = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Draw draw : drawings) {
            draw.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawings.add(new Dot(e.getX(), e.getY()));
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
