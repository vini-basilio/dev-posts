package edu.blog.dev_posts.service;

import edu.blog.dev_posts.domain.DTOs.PostCreateDTO;
import edu.blog.dev_posts.domain.model.Post;

public interface PostService {

    Post createPost(PostCreateDTO post, Long id);
}
