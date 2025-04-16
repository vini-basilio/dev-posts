package edu.blog.dev_posts.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateDTO {
    private Long userId;
    private String post;
}
