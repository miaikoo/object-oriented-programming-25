import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends JFrame
{
    private JLabel imageLabel;
    private JButton btnOpen;

    public ImageViewer()
    {
        setTitle("Aplikasi Image Viewer");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("Tidak ada gambar", SwingConstants.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        btnOpen = new JButton("Buka Gambar");
        btnOpen.addActionListener(e -> pilihGambar());
        add(btnOpen, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void pilihGambar()
    {
        JFileChooser fileChooser = new JFileChooser();
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            ImageIcon icon = new ImageIcon(path);
            
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(500, 400,  java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImg);
            
            imageLabel.setText("");
            imageLabel.setIcon(icon);
        }
    }
}