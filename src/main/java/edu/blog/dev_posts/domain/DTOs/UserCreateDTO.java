package edu.blog.dev_posts.domain.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateDTO {
    @NotNull(message = "Cannot be null")
    @Size(min = 5, max = 50, message = "Name should be between 5 and 50 letter")
    private String name;
    @Schema(description = "User's email address", example = "user@example.com", required = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String login;
}
