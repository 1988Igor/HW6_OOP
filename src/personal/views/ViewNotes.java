package personal.views;


import personal.controllers.NoteController;
import personal.model.Fields;
import personal.model.Notes;
import personal.model.Repository;


import java.util.Date;
import java.util.Scanner;

public class ViewNotes {

    private final NoteController noteController;

    private final Repository repository;

    public ViewNotes(NoteController noteController, Repository repository) {
        this.noteController = noteController;
        this.repository = repository;
    }

    public void run() {
        Commands com = Commands.NONE;
        showHelp();
        while (true) {
            try {
                String command = prompt("Enter a command: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case HELP:
                        showHelp();
                }
            } catch (Exception ex) {
                System.out.println("An error has occurred " + ex.toString());
            }
        }
    }

    private void read() throws Exception {
        String id = prompt("User ID: ");
        Notes notesRead = noteController.readNotes(id);
        System.out.println(notesRead);
    }

    private void update() throws Exception {
        String notesId = prompt("User ID: ");
        String field_name = prompt("Which field (Title,Text): ");
        String param = null;
            //can be problems
        param = prompt("Enter what you want to change: ");

        Notes _notes = noteController.readNotes(notesId);
        noteController.updateNotes(_notes, Fields.valueOf(field_name.toUpperCase()), param);
    }



    private void list() throws Exception {
        for (Notes notes : noteController.getNotes()) {
            System.out.println(notes);
        }
    }

    private void create() throws Exception {
        String text = prompt("Text: ");
        String title = prompt("Title: ");
        String date = prompt("Date: ");
        noteController.saveNotes(new Notes(text,title, date));
    }

    private void showHelp() {
        System.out.println("List of commands:");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void delete() throws Exception {
        String notesId = prompt("Enter the ID user for deleting: ");
        Notes notes = noteController.readNotes(notesId);
        if (notes.getId().equals(notesId)) {
            repository.deleteNotes(notesId);
        }

    }
}