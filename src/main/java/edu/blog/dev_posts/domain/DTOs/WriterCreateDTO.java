package edu.blog.dev_posts.domain.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WriterCreateDTO {
    @NotNull(message = "Name can not be null")
    @Size(min = 5, max = 50, message = "Name should be between 5 and 50 letter")
    private String name;
    @Schema(description = "User's email address", example = "user@example.com")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String login;

    public String getAdminPassword() {
        return adminPassword;
    }

    private String adminPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Password is required")
    @Size(min = 5, max = 50, message = "Password should be between 5 and 50 letter")
    private String password;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
