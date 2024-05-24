package com.memesapp.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MemesDto {
    private Long id;
    @NotEmpty(message = "Meme Title cannot be empty")
    private String title;
    @NotEmpty(message = "Please upload a Meme Image file (png, jpeg, jpg, gif)")
    private byte[] image;
    @NotEmpty(message = "Please select a Category for this Meme")
    private String category;
    @NotEmpty(message = "Please select a Label for this Meme")
    private String labels;
    private LocalDateTime  createdOn;
    private LocalDateTime updatedOn;
    private String createdBy;
}
