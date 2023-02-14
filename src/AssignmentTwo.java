import javax.swing.*;
import java.awt.*;

/**
 * The assignment class that extends itself to be a JFrame and implements ActionListener. The class has a main that
 * runs the GUI. The class also sets up the GUI and holds implementation for user input.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */

public class AssignmentTwo extends JFrame {

    /**
     * The main method to test the Assignment GUI.
     *
     **/
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

        DrawArea drawArea = new DrawArea();
        OptionsArea leftPanel = new OptionsArea();
        leftPanel.addObserver(drawArea);

        add(leftPanel, BorderLayout.WEST);
        add(drawArea, BorderLayout.CENTER);

        setTitle("Connect The Colored Dots");
        setSize(500, 500);
        setVisible(true);
    }


}