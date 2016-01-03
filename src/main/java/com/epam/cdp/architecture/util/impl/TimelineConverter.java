package com.epam.cdp.architecture.util.impl;

import com.epam.cdp.architecture.model.dto.TimelineDTO;
import com.epam.cdp.architecture.model.entity.Timeline;
import com.epam.cdp.architecture.util.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class TimelineConverter extends AbstractConverter<Timeline, TimelineDTO> {

    @Override
    public TimelineDTO convert(Timeline timeline) {
        TimelineDTO converted = null;
        if (timeline != null) {
            converted = new TimelineDTO();
            converted.setNoteText(timeline.getNoteText());
            converted.setAuthor(timeline.getNoteAuthor());
        }
        return converted;
    }
}
