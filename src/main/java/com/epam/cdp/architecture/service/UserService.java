package com.epam.cdp.architecture.service;

import com.epam.cdp.architecture.model.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    User createUser(String username, String name, Date dateOfBirth);

    boolean addFriend(String user, String friend);

    List<User> getAllFriends(String username);

    boolean isFriendOf(String username, String friendName);
}
