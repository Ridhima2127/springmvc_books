package com.rungroup.web.service;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.dto.StoryDto;

import java.util.List;

public interface StoryService {
    void createStory(Long bookId, StoryDto storyDto);

    List<StoryDto> findAllStories();


    StoryDto findByStoryId(Long storyId);

    void updateStory(StoryDto storyDto);

    void deleteStory(long storyId);
}
