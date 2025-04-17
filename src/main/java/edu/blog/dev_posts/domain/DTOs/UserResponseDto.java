package edu.blog.dev_posts.domain.DTOs;

import edu.blog.dev_posts.domain.model.Post;
import edu.blog.dev_posts.domain.roles.*;

import java.util.List;

public record UserResponseDto(Long id, String name, UserRole role, List<Post> post) {
}
