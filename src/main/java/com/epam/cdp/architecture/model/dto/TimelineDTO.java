package com.epam.cdp.architecture.model.dto;

public class TimelineDTO {
    private String noteText;
    private String author;

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
