package personal.model;

import java.util.Date;

public class NotesMapper {
    public String map(Notes notes) {
        return String.format("%s/%s/%s/%s/", notes.getId(),notes.getTitle(), notes.getText(), notes.getDate());
    }

    public Notes map(String line) {
        String[] lines = line.split(";");
        if(lines.length < 4){
            return null;
        }
        return new Notes(lines[0], lines[1], lines[2],lines[3]);
    }
}
