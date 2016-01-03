package com.epam.cdp.architecture.facade.impl;

import com.epam.cdp.architecture.facade.EpamBookFacade;
import com.epam.cdp.architecture.model.dto.TimelineDTO;
import com.epam.cdp.architecture.model.dto.UserDTO;
import com.epam.cdp.architecture.model.entity.Timeline;
import com.epam.cdp.architecture.model.entity.User;
import com.epam.cdp.architecture.service.TimelineService;
import com.epam.cdp.architecture.service.UserService;
import com.epam.cdp.architecture.util.impl.TimelineConverter;
import com.epam.cdp.architecture.util.impl.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EpamBookFacadeImpl implements EpamBookFacade {

    @Autowired
    UserService userService;

    @Autowired
    TimelineService timelineService;

    @Autowired
    UserConverter userConverter;

    @Autowired
    TimelineConverter timelineConverter;

    @Override
    public boolean createUser(UserDTO user) {
        User userModel = userService.createUser(user.getUsername(), user.getName(), user.getDateOfBirth().getTime());
        return userModel != null;
    }

    @Override
    public boolean addNote(String username, TimelineDTO timeline) {
        Timeline note = timelineService.createNote(timeline.getNoteText(), timeline.getAuthor(), username);
        return note != null;
    }

    @Override
    public List<TimelineDTO> getNotes(String username) {
        List<Timeline> all = timelineService.getAll(username);
        return timelineConverter.convertAll(all);
    }

    @Override
    public List<TimelineDTO> getNotes(String username, String friendName) {
        if (userService.isFriendOf(username, friendName)) {
            List<Timeline> all = timelineService.getAll(friendName);
            return timelineConverter.convertAll(all);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean addFriend(String user, String username) {
        return userService.addFriend(user, username);
    }

    @Override
    public List<UserDTO> getAllFriends(String username) {
        List<User> all = userService.getAllFriends(username);
        return userConverter.convertAll(all);
    }
}
