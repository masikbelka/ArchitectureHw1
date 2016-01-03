package com.epam.cdp.architecture.service;

import com.epam.cdp.architecture.model.entity.Timeline;

import java.util.List;

public interface TimelineService {
    Timeline createNote(String noteText, String noteAuthor, String timelineOwner);

    List<Timeline> getAll(String username);
}
