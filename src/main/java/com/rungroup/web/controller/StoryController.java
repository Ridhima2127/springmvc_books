package com.rungroup.web.controller;


import com.rungroup.web.dto.BookDto;
import com.rungroup.web.dto.StoryDto;
import com.rungroup.web.models.Story;
import com.rungroup.web.models.UserEntity;
import com.rungroup.web.security.SecurityUtil;
import com.rungroup.web.service.StoryService;
import com.rungroup.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StoryController {

    private StoryService storyService;
    private UserService userService;

    @Autowired
    public StoryController(StoryService storyService, UserService userService) {
        this.userService = userService;
        this.storyService = storyService;
    }

    @GetMapping("/stories")
    public String storyList(Model model){
        UserEntity user = new UserEntity();
        List<StoryDto> stories = storyService.findAllStories();
        String username = SecurityUtil.getSessionUser();
        if(username != null){
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);
        model.addAttribute("stories",stories);
        return "stories-list";
    }


    @GetMapping("/stories/{storyId}")
    public String viewStory(@PathVariable("storyId")Long storyId, Model model){
        UserEntity user = new UserEntity();
        StoryDto storyDto = storyService.findByStoryId(storyId);
        String username = SecurityUtil.getSessionUser();
        if(username != null){
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("book", storyDto);
        model.addAttribute("user",user);
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
    public String createStory(@PathVariable("bookId") Long bookId, @ModelAttribute("story")StoryDto storyDto,BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("story", storyDto);
            return "stories-create";
        }

        storyService.createStory(bookId, storyDto);
        return "redirect:/books/" + bookId;
    }

    @PostMapping("/stories/{storyId}/edit")
    public String updateStory(@PathVariable("storyId") Long storyId, @Valid @ModelAttribute("story") StoryDto story, BindingResult result, Model model){
        if(result.hasErrors()){
            return "stories-edit";
        }
        StoryDto storyDto = storyService.findByStoryId(storyId);
        story.setId(storyId);
        story.setBook(storyDto.getBook());
        storyService.updateStory(story);
        return "redirect:/stories";
    }

    @GetMapping("/stories/{storyId}/delete")
    public String deleteStory(@PathVariable("storyId") long storyId){
        storyService.deleteStory(storyId);
        return "redirect:/stories";
    }

}
