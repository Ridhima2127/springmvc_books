package com.rungroup.web.dto;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
