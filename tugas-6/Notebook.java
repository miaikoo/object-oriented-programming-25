import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(String title, String content) {
        notes.add(new Note(title, content));
    }

    public ArrayList<Note> getAllNotes() {
        return notes;
    }

    public ArrayList<Note> searchNotes(String keyword) {
        ArrayList<Note> result = new ArrayList<>();
        keyword = keyword.toLowerCase();

        for (Note note : notes) {
            if (note.getTitle().toLowerCase().contains(keyword)) {
                result.add(note);
            }
        }
        return result;
    }

    public boolean deleteNote(String title) {
        String t = title.toLowerCase();
        return notes.removeIf(note -> note.getTitle().toLowerCase().equals(t));
    }
}
