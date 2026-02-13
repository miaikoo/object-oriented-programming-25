import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock extends JFrame implements ActionListener
{
    private ClockDisplay clock;
    private JLabel timeLabel;
    private Timer timer;

    public Clock()
    {
        super("Digital Clock");

        clock = new ClockDisplay();
        timeLabel = new JLabel(clock.getTime(), SwingConstants.CENTER);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 48));

        // Timer, 1000 ms = 1 detik
        timer = new Timer(1000, this);

        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");
        JButton stepBtn = new JButton("Step");

        startBtn.addActionListener(e -> timer.start());
        stopBtn.addActionListener(e -> timer.stop());
        stepBtn.addActionListener(e -> updateClock());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startBtn);
        buttonPanel.add(stopBtn);
        buttonPanel.add(stepBtn);

        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem quitItem = new JMenuItem("Quit");

        aboutItem.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Simple Digital Clock – BlueJ")
        );

        quitItem.addActionListener(e -> System.exit(0));

        menu.add(aboutItem);
        menu.add(quitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        updateClock();
    }

    private void updateClock()
    {
        clock.timeTick();
        timeLabel.setText(clock.getTime());
    }

    public static void main(String[] args)
    {
        new Clock();
    }
}
