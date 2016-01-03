package com.epam.cdp.architecture.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "timelines")
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String noteText;

    @NotNull
    private String noteAuthor;

    private String timelineOwner;

    public Timeline() {
    }

    public Timeline(String noteText, String noteAuthor, String timelineOwner) {
        this.noteText = noteText;
        this.noteAuthor = noteAuthor;
        this.timelineOwner = timelineOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteAuthor() {
        return noteAuthor;
    }

    public void setNoteAuthor(String noteAuthor) {
        this.noteAuthor = noteAuthor;
    }

    public String getTimelineOwner() {
        return timelineOwner;
    }

    public void setTimelineOwner(String timelineOwner) {
        this.timelineOwner = timelineOwner;
    }
}
