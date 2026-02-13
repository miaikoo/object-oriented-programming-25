import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener
{
    private JTextField userField;
    private JPasswordField passField;
    private JButton btnLogin;

    public LoginFrame()
    {
        setTitle("Login System");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        // Komponen UI
        add(new JLabel("  Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("  Password:"));
        passField = new JPasswordField();
        add(passField);

        add(new JLabel(""));
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (user.equals("admin") && pass.equals("123")) {
            JOptionPane.showMessageDialog(this, "Login Berhasil!");
            
            new ImageViewer(); 
            this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password Salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}