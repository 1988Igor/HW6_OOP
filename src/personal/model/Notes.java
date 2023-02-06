package personal.model;

import java.util.Date;

public class Notes {

    private String id = "";
    private String title;
    private String text;

    private String date;

    public Notes(String title, String text, String date) {

        this.title = title;
        this.text = text;
        this.date = date;
    }
    public Notes(String id, String text, String title, String date){
        this(text, title, date);
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }
    public   String setDate(){
        return date;
    }




    @Override
    public String toString() {
        return String.format("Identifier: %s| Titel: %s; Text: %s; Data: %s", id, title, text, date);
    }
}