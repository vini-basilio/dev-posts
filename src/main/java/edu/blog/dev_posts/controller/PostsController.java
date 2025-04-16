package edu.blog.dev_posts.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.blog.dev_posts.domain.DTOs.PostCreateDTO;

import edu.blog.dev_posts.domain.model.Post;
import edu.blog.dev_posts.service.PostService;
import jakarta.validation.Valid;

@Validated
@RestController
public class PostsController {

    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("users/{userId}/posts")
    public ResponseEntity<Post> create(@Valid @RequestBody PostCreateDTO post, @PathVariable long userId) {
        var createdPost = postService.createPost(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPost.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdPost);
    }
}
