package com.rungroup.web.dto;
import com.rungroup.web.models.UserEntity;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookDto {
    private Long id;
    @NotEmpty(message = "Book title should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoURL;
    @NotEmpty(message = "Book content should not be empty")
    private String content;

    private UserEntity createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    private List<StoryDto> stories;

}
