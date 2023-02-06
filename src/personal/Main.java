package personal;


import personal.controllers.NoteController;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.Repository;
import personal.model.RepositoryFile;
import personal.views.ViewNotes;

public class Main {

    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("MyUsers.txt");
        Repository repository = new RepositoryFile(fileOperation);
        NoteController controller = new NoteController(repository);
        ViewNotes view = new ViewNotes(controller,repository);
        view.run();
    }
}