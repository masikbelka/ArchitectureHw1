package com.epam.cdp.architecture.facade;


import com.epam.cdp.architecture.model.dto.TimelineDTO;
import com.epam.cdp.architecture.model.dto.UserDTO;

import java.util.List;

public interface EpamBookFacade {
    boolean createUser(UserDTO user);

    boolean addNote(String username, TimelineDTO timeline);

    List<TimelineDTO> getNotes(String username);

    List<TimelineDTO> getNotes(String username, String friendName);

    boolean addFriend(String user, String username);

    List<UserDTO> getAllFriends(String username);
}
