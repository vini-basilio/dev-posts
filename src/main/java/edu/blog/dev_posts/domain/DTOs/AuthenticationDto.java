package edu.blog.dev_posts.domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDto(@NotBlank String login, @NotBlank String password) {

    @Override
    public String login() {
        return login;
    }

    @Override
    public String password() {
        return password;
    }
}
