package com.rungroup.web.service.impl;

import com.rungroup.web.dto.StoryDto;
import com.rungroup.web.models.Book;
import com.rungroup.web.models.Story;
import com.rungroup.web.repository.BookRepository;
import com.rungroup.web.repository.StoryRepository;
import com.rungroup.web.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rungroup.web.mapper.StoryMapper.mapToStory;

public class StoryServiceImpl implements StoryService {

    private StoryRepository storyRepository;
    private BookRepository bookRepository;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository, BookRepository bookRepository){
        this.storyRepository = storyRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void createStory(Long bookId, StoryDto storyDto) {
        Book book = bookRepository.findById(bookId).get();
        Story story = mapToStory(storyDto);
        story.setBook(book);
        storyRepository.save(story);
    }




}
