package com.rungroup.web.dto;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
public class BookDto {
    private Long id;
    @NotEmpty(message = "Book title should not be empty")
    private String title;
    @NotEmpty(message = "Book description should not be empty")
    private String description;
    @NotEmpty(message = "Book category should not be empty")
    private String category;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;


}
