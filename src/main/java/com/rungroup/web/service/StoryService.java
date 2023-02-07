package com.rungroup.web.service;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.dto.StoryDto;

public interface StoryService {
    void createStory(Long bookId, StoryDto storyDto);


}
