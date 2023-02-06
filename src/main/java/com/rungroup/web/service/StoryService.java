package com.rungroup.web.service;

import com.rungroup.web.dto.BookDto;

public interface StoryService {
    void createStory(Long bookId, BookDto bookDto);
}
