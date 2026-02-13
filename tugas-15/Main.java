import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game Java - Latihan BlueJ");
        GamePanel panel = new GamePanel();
        
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}