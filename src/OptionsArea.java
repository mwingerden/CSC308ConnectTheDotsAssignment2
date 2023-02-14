import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates a JPanel of Options for the user. Is an observable so that the class can update the observer to execute
 * the options the user clicked on.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */
public class OptionsArea extends JPanel implements ActionListener, Observable {
    DrawArea drawArea;
    Boolean cluster;
    Boolean connect;

    /**
     * Construction of the left hand side of the GIU.
     *
     **/
    public OptionsArea() {
        this.cluster = false;
        this.connect = false;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JCheckBox cluster = new JCheckBox("Cluster - K-means");
        cluster.addActionListener(this);
        add(cluster);

        JCheckBox line = new JCheckBox("Line - Nearest Neighbor");
        line.addActionListener(this);
        add(line);

        JButton run = new JButton("Run");
        run.addActionListener(this);
        add(run);
    }

    /**
     * Overrides the method actionPerformed in order to handle user input for the assignment.
     *
     * @param e     Holds information of the user's action.
     *
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cluster - K-means")) {
            drawArea.updateCluster();
        }
        else if(e.getActionCommand().equals("Line - Nearest Neighbor")) {
            drawArea.updateConnect();
        }
        else if(e.getActionCommand().equals("Run")) {
            drawArea.update();
        }
    }

    /**
     * Adds an observer to the class.
     *
     * @param drawArea      The JPanel to be updated.
     *
     **/
    @Override
    public void addObserver(DrawArea drawArea) {
        this.drawArea = drawArea;
    }
}
