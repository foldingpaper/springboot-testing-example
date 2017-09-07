package org.skexample;

public class Greeting {

    private long id;
    private String text;

    public Greeting() {
    }

    public Greeting(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
