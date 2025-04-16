package edu.blog.dev_posts.domain.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateDTO {
    @NotNull(message = "Title can not be null")
    @Size(min = 1, max = 255, message = "Post should be between 1 and 255 letter")
    private String title;
    @NotNull(message = "Post can not be null")
    @Size(min = 1, max = 255, message = "Post should be between 1 and 255 letter")
    private String post;
}
