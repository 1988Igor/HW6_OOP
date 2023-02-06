package personal.controllers;


import personal.model.Fields;
import personal.model.Notes;
import personal.model.Repository;

import java.util.List;

public class NoteController {
    private final Repository repository;


    public NoteController(Repository repository) {
        this.repository = repository;

    }

    public void saveNotes(Notes notes) throws Exception {
        repository.createNotes(notes);
    }

    public void updateNotes(Notes notes, Fields field, String param) throws Exception {

        repository.UpdateNotes(notes, field, param);


    }

    public Notes readNotes(String noteId) throws Exception {
        List<Notes> notes = repository.getAllNotes();
        for (Notes note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }

        throw new Exception("Note not found");
    }

    public List<Notes> getNotes() throws Exception {
        return repository.getAllNotes();
    }


}










