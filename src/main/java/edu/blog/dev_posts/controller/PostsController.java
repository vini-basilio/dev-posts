package edu.blog.dev_posts.controller;

import java.net.URI;

import edu.blog.dev_posts.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.blog.dev_posts.domain.DTOs.PostCreateDTO;

import edu.blog.dev_posts.domain.model.Post;
import edu.blog.dev_posts.service.PostService;
import jakarta.validation.Valid;

@Validated
@RestController
public class PostsController {
    @Autowired
    private PostService postService;

    @PostMapping("users/posts")
    public ResponseEntity<Post> create(@Valid @RequestBody PostCreateDTO post, @AuthenticationPrincipal User user) {

        var createdPost = postService.createPost(post, user.getId());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPost.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdPost);
    }
}
