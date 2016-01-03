package com.epam.cdp.architecture.controllers;

import com.epam.cdp.architecture.model.dto.TimelineDTO;
import com.epam.cdp.architecture.model.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(UserDTO user) {

    }

    @RequestMapping(value = "{username}/timeline", method = RequestMethod.POST)
    public void postToTimeline(@PathVariable String username, TimelineDTO timeline) {

    }

    @RequestMapping(value = "{username}/timeline", method = RequestMethod.GET)
    public void getTimeline(@PathVariable String username) {

    }

    @RequestMapping(value = "{username}/friend", method = RequestMethod.POST)
    public void addFriend(@PathVariable String username) {

    }

    @RequestMapping(value = "{username}/friend", method = RequestMethod.GET)
    public void getFriends(@PathVariable String username) {

    }

    @RequestMapping(value = "{username}/friend/{friendName}/timeline", method = RequestMethod.GET)
    public void getFriendTimeline(@PathVariable String username, @PathVariable String friendName) {

    }

     @RequestMapping(value = "{username}/friend/{friendName}/timeline", method = RequestMethod.GET)
    public void postToFriendTimeline(@PathVariable String username, @PathVariable String friendName) {

    }



}
