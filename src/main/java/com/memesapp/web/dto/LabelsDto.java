package com.memesapp.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LabelsDto {
    private Long id;
    @NotEmpty(message = "Label Name cannot be empty")
    private String labelName;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
