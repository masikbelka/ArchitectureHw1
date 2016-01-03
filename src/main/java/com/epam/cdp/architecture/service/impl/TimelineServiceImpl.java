package com.epam.cdp.architecture.service.impl;

import com.epam.cdp.architecture.model.dao.TimelineDao;
import com.epam.cdp.architecture.model.entity.Timeline;
import com.epam.cdp.architecture.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    TimelineDao timelineDao;

    @Override
    public Timeline createNote(String noteText, String noteAuthor, String timelineOwner) {
        Timeline timeline = new Timeline(noteText, noteAuthor, timelineOwner);
        return timelineDao.save(timeline);
    }

    @Override
    public List<Timeline> getAll(String username) {
        return timelineDao.findPleaseByTimelineOwner(username);
    }
}
