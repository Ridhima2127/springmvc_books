package com.rungroup.web.mapper;

import com.rungroup.web.dto.StoryDto;
import com.rungroup.web.models.Story;

public class StoryMapper {
    public static Story mapToStory (StoryDto storyDto){
        return Story.builder()
                .id(storyDto.getId())
                .name(storyDto.getName())
                .startTime(storyDto.getStartTime())
                .endTime(storyDto.getEndTime())
                .type(storyDto.getType())
                .createdOn(storyDto.getCreatedOn())
                .updatedOn(storyDto.getUpdatedOn())
                .build();

    }
    public static StoryDto mapToStoryDto(Story story){
        return StoryDto.builder()
                .id(story.getId())
                .name(story.getName())
                .startTime(story.getStartTime())
                .endTime(story.getEndTime())
                .type(story.getType())
                .createdOn(story.getCreatedOn())
                .updatedOn(story.getUpdatedOn())
                .build();

    }
}
