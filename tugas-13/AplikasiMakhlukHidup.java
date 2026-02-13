import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiMakhlukHidup extends JFrame
{
    private JTextArea areaTeks;
    private JPanel panelTombol;

    public AplikasiMakhlukHidup()
    {
        // Setup Jendela Utama
        setTitle("Simulasi Abstract Class Makhluk Hidup");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Area Teks untuk Output
        areaTeks = new JTextArea();
        areaTeks.setEditable(false);
        areaTeks.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(areaTeks), BorderLayout.CENTER);

        // Panel Tombol
        panelTombol = new JPanel();
        panelTombol.setLayout(new FlowLayout());

        JButton btnManusia = new JButton("Info Manusia");
        JButton btnHewan = new JButton("Info Hewan");
        JButton btnTumbuhan = new JButton("Info Tumbuhan");
        JButton btnClear = new JButton("Hapus");

        // Menambahkan aksi ke tombol Manusia
        btnManusia.addActionListener(e -> {
            MakhlukHidup m = new Manusia("Budi");
            tampilkanInfo(m);
        });

        // Menambahkan aksi ke tombol Hewan
        btnHewan.addActionListener(e -> {
            MakhlukHidup h = new Hewan("Harimau", "Karnivora");
            tampilkanInfo(h);
        });

        // Menambahkan aksi ke tombol Tumbuhan
        btnTumbuhan.addActionListener(e -> {
            MakhlukHidup t = new Tumbuhan("Anggrek");
            tampilkanInfo(t);
        });

        // Tombol Bersihkan Layar
        btnClear.addActionListener(e -> areaTeks.setText(""));

        panelTombol.add(btnManusia);
        panelTombol.add(btnHewan);
        panelTombol.add(btnTumbuhan);
        panelTombol.add(btnClear);

        add(panelTombol, BorderLayout.SOUTH);

        // Tampilkan
        setVisible(true);
    }

    // Method Polymorphism untuk menampilkan data ke layar GUI
    private void tampilkanInfo(MakhlukHidup mh)
    {
        String info = "=== " + mh.getNama() + " ===\n" +
                      "Status: " + mh.getClass().getSimpleName() + "\n" +
                      "Nafas : " + mh.caraBernafas() + "\n" +
                      "Makan : " + mh.caraMakan() + "\n\n";
        
        areaTeks.append(info);
    }
    
    // Main method untuk menjalankan langsung
    public static void main(String[] args) {
        new AplikasiMakhlukHidup();
    }
}