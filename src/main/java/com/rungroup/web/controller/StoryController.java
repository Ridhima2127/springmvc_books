package com.rungroup.web.controller;


import com.rungroup.web.dto.StoryDto;
import com.rungroup.web.models.Story;
import com.rungroup.web.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StoryController {

    private StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("/stories")
    public String storyList(Model model){
        List<StoryDto> stories = storyService.findAllStories();
        model.addAttribute("stories",stories);
        return "stories-list";
    }


    @GetMapping("/stories/{storyId}")
    public String viewStory(@PathVariable("storyId")Long storyId, Model model){
        StoryDto storyDto = storyService.findByStoryId(storyId);
        model.addAttribute("story", storyDto);
        return "stories-detail";
    }

    @GetMapping("/stories/{bookId}/new")
    public String createStoryForm(@PathVariable("bookId") Long bookId, Model model){
        Story story = new Story();
        model.addAttribute("bookId", bookId);
        model.addAttribute("story", story);
        return "stories-create";
    }

    @GetMapping("/stories/{storyId}/edit")
    public String editStoryForm(@PathVariable("storyId") Long storyId, Model model){
        StoryDto story = storyService.findByStoryId(storyId);
        model.addAttribute("story", story);
        return "stories-edit";
    }

    @PostMapping("/stories/{bookId}")
    public String createStory(@PathVariable("bookId") Long bookId, @ModelAttribute("story")StoryDto storyDto, Model model){
        storyService.createStory(bookId, storyDto);
        return "redirect:/books/" + bookId;
    }

}
