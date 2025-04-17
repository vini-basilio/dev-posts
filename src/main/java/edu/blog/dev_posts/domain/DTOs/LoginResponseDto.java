package edu.blog.dev_posts.domain.DTOs;

public record LoginResponseDto(String token) {

    public String token() {
        return token;
    }
}