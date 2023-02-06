package personal.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private NotesMapper mapper = new NotesMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Notes> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Notes> notes = new ArrayList<>();
        for (String line : lines) {
            Notes note = mapper.map(line);
            if(note != null){
            notes.add(mapper.map(line));

        }
        }
        return notes;
    }

    @Override
    public void UpdateNotes(Notes notes, Fields field, String param) {
        if (field == Fields.Text) {
            notes.setText(param);
        } else if (field == Fields.Title) {
            notes.setTitle(param);
        } else if (field==Fields.Date) {
            notes.setDate();

        }
        saveNotes(notes);
    }

    @Override
    public void deleteNotes(String noteId) {
        List<Notes> notes = getAllNotes();
        Notes notesToDelete = null;
        for (Notes note : notes) {
            if (note.getId().equals(noteId)) {
                notesToDelete = note;
                break;
            }
        }
        notes.remove(notesToDelete);
        List<String> lines = new ArrayList<>();
        for (Notes note : notes) {
            lines.add(mapper.map(note));
        }
        fileOperation.saveAllLines(lines);
    }

    private void saveNotes(Notes notes) {
        List<String> lines = new ArrayList<>();
        List<Notes> note = getAllNotes();
        for (Notes item : note) {
            if (notes.getId().equals(item.getId())) {
                lines.add(mapper.map(notes));

            } else {
                lines.add(mapper.map(item));
            }
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public String createNotes(Notes notes) {

        List<Notes> note = getAllNotes();
        int max = 0;
        for (Notes item : note) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        notes.setId(id);
        note.add(notes);
        List<String> lines = new ArrayList<>();
        for (Notes item : note) {
            lines.add(mapper.map(item));

        }
        fileOperation.saveAllLines(lines);
        return id;
    }

}
