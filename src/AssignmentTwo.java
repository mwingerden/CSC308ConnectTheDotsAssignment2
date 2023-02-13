import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The assignment class that extends itself to be a JFrame and implements ActionListener. The class has a main that
 * runs the GUI. The class also sets up the GUI and holds implementation for user input.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */

public class AssignmentTwo extends JFrame implements ActionListener {
    DrawArea drawArea = new DrawArea();
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.runGUI();
    }

    /**
     * Runs and sets up the GUI for this assignment
     *
     **/
    public void runGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JCheckBox cluster = new JCheckBox("Cluster - K-means");
        cluster.addActionListener(this);
        leftPanel.add(cluster);

        JCheckBox line = new JCheckBox("Line - Nearest Neighbor");
        line.addActionListener(this);
        leftPanel.add(line);

        JButton run = new JButton("Run");
        run.addActionListener(this);
        leftPanel.add(run);


        JPanel centerPanel = drawArea;
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.DARK_GRAY);


        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);


        setTitle("Connect The Colored Dots");
        setSize(500, 500);
        setVisible(true);
    }

    /**
     * Overrides the method actionPerformed in order to handle user input for the assignment.
     *
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cluster - K-means")) {
            drawArea.setCluster();
        }
        else if(e.getActionCommand().equals("Line - Nearest Neighbor")) {
            drawArea.setLine();
        }
        else if(e.getActionCommand().equals("Run")) {
            drawArea.run();
        }
    }
}