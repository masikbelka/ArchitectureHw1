package com.epam.cdp.architecture.controllers;

import com.epam.cdp.architecture.facade.EpamBookFacade;
import com.epam.cdp.architecture.model.SitePages;
import com.epam.cdp.architecture.model.dto.TimelineDTO;
import com.epam.cdp.architecture.model.dto.UserDTO;
import com.epam.cdp.architecture.util.DatePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    EpamBookFacade epamBookFacade;

    @Autowired
    private DatePropertyEditor datePropertyEditor;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Calendar.class, datePropertyEditor);
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public String createUser(UserDTO user, Model model) {
        boolean created = epamBookFacade.createUser(user);
        if (created) {
            model.addAttribute("message", "User " + user.getName() + " was successfully created" );
            return SitePages.SUCCESS;
        }
        return SitePages.ERROR;
    }

    @RequestMapping(value = "/{user}/timeline", method = RequestMethod.POST)
    public String postToTimeline(@PathVariable String user, TimelineDTO timeline, Model model) {
        boolean created = epamBookFacade.addNote(user, timeline);
        if (created) {
            model.addAttribute("message", "Note was successfully added" );
            return SitePages.SUCCESS;
        }
        return SitePages.ERROR;
    }

    @RequestMapping(value = "/{user}/timeline", method = RequestMethod.GET)
    public ModelAndView getTimeline(@PathVariable String user, Model model) {
        List<TimelineDTO> notes = epamBookFacade.getNotes(user);
        model.addAttribute("notes", notes);
        return new ModelAndView(SitePages.USER_TIMELINE).addObject("notes", notes);
    }

    @RequestMapping(value = "/{user}/friend", method = RequestMethod.POST)
    public String addFriend(@PathVariable String user, String username, Model model) {
        boolean friendAdded = epamBookFacade.addFriend(user, username);
        if (friendAdded) {
            model.addAttribute("message", "Friend " + username + " was successfully added" );
            return SitePages.SUCCESS;
        }
        model.addAttribute("message", "Friend " + username + " wasn't added" );
        return SitePages.ERROR;
    }

    @RequestMapping(value = "/{username}/friend", method = RequestMethod.GET)
    public String getFriends(@PathVariable String username, Model model) {
        List<UserDTO> friends = epamBookFacade.getAllFriends(username);
        model.addAttribute("friends", friends);
        return SitePages.FRIENDS;
    }

    @RequestMapping(value = "/{username}/friend/{friendName}/timeline", method = RequestMethod.GET)
    public String getFriendTimeline(@PathVariable String username, @PathVariable String friendName, Model model) {
        List<TimelineDTO> notes = epamBookFacade.getNotes(username, friendName);
        model.addAttribute("timeline", notes);
        return SitePages.USER_TIMELINE;
    }

     @RequestMapping(value = "/{username}/friend/{friendName}/timeline", method = RequestMethod.POST)
    public String postToFriendTimeline(@PathVariable String username, @PathVariable String friendName, TimelineDTO timeline) {
         boolean noteAdded = epamBookFacade.addNote(friendName, timeline);
         if (noteAdded) {
             return SitePages.SUCCESS;
         }
         return SitePages.ERROR;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("message", "was successfully added" );
        return "successPage";
    }



}
