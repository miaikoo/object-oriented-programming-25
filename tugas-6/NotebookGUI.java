import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NotebookGUI extends JFrame {

    private Notebook notebook;
    private JTextArea displayArea;

    public NotebookGUI() {
        notebook = new Notebook();

        setTitle("Personal Notebook");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);
        add(scroll, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton addBtn = new JButton("Tambah");
        JButton viewBtn = new JButton("Lihat");
        JButton searchBtn = new JButton("Cari");
        JButton deleteBtn = new JButton("Hapus");

        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(deleteBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        addBtn.addActionListener(e -> addNote());
        viewBtn.addActionListener(e -> viewNotes());
        searchBtn.addActionListener(e -> searchNotes());
        deleteBtn.addActionListener(e -> deleteNote());

        setVisible(true);
    }

    private void addNote() {
        String title = JOptionPane.showInputDialog(this, "Judul:");
        if (title == null || title.isEmpty()) return;

        String content = JOptionPane.showInputDialog(this, "Isi catatan:");
        if (content == null) return;

        notebook.addNote(title, content);
        displayArea.setText("Catatan ditambahkan!");
    }

    private void viewNotes() {
        ArrayList<Note> notes = notebook.getAllNotes();
        if (notes.isEmpty()) {
            displayArea.setText("Belum ada catatan.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Note note : notes) {
            sb.append(note.toString()).append("\n\n");
        }
        displayArea.setText(sb.toString());
    }

    private void searchNotes() {
        String keyword = JOptionPane.showInputDialog(this, "Cari judul:");
        if (keyword == null) return;

        ArrayList<Note> result = notebook.searchNotes(keyword);

        if (result.isEmpty()) {
            displayArea.setText("Catatan tidak ditemukan.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Note note : result) {
            sb.append(note.toString()).append("\n\n");
        }
        displayArea.setText(sb.toString());
    }

    private void deleteNote() {
        String title = JOptionPane.showInputDialog(this, "Judul yang dihapus:");
        if (title == null) return;

        boolean removed = notebook.deleteNote(title);
        if (removed) {
            displayArea.setText("Catatan berhasil dihapus.");
        } else {
            displayArea.setText("Judul tidak ditemukan.");
        }
    }
}
