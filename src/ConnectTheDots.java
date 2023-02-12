import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectTheDots extends JFrame implements ActionListener {
    public static void main(String[] args) {
        ConnectTheDots connectTheDots = new ConnectTheDots();
        connectTheDots.runGUI();
    }

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


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);


        setTitle("Connect The Dots");
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cluster - K-means")) {
            System.out.println("Cluster - K-means");
        }
        else if(e.getActionCommand().equals("Line - Nearest Neighbor")) {
            System.out.println("Line - Nearest Neighbor");
        }
        else if(e.getActionCommand().equals("Run")) {
            System.out.println("Run");
        }
    }
}