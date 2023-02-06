package personal.model;

import java.util.List;

public interface Repository {
    List<Notes> getAllNotes();
    String createNotes(Notes notes);
    void UpdateNotes(Notes notes, Fields field, String param);

    void deleteNotes(String noteId);


}

