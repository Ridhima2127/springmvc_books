package com.rungroup.web.controller;


import com.rungroup.web.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StoryController {

    private StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService){
        this.storyService = storyService;
    }
}
