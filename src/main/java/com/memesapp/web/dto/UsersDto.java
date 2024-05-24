package com.memesapp.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UsersDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty", groups = {Default.class})
    private String name;
    @NotEmpty(message = "Username cannot be empty", groups = {Default.class})
    private String username;
    @NotEmpty(message = "Email cannot be empty", groups = {Default.class, EmailOnly.class})
    private String email;
    @NotEmpty(message = "Password cannot be empty", groups = {Default.class})
    private String password;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    // Custom Validation Group for "Update Account Details" page, where only Email address update is allowed.
    public interface EmailOnly {}
}
