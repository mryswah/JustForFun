package com.memesapp.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoriesDto {
    private Long id;
    @NotEmpty(message = "Category Name cannot be empty")
    private String categoryName;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
