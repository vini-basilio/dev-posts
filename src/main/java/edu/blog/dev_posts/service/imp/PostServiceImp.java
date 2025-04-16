package edu.blog.dev_posts.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.blog.dev_posts.domain.DTOs.PostCreateDTO;
import edu.blog.dev_posts.domain.model.Post;
import edu.blog.dev_posts.domain.repository.PostRespository;

import edu.blog.dev_posts.service.PostService;
import edu.blog.dev_posts.service.UserService;

@Service
public class PostServiceImp implements PostService {
    private final PostRespository postRespository;

    @Autowired
    private UserService userService;

    public PostServiceImp(PostRespository respository) {
        this.postRespository = respository;
    }

    @Override
    public Post createPost(PostCreateDTO post) {
        var user = userService.findById(post.getUserId());
        var postToSave = new Post();
        postToSave.setPost(post.getPost());
        postToSave.setUser(user);
        return postRespository.save(postToSave);
    }

    @Override
    public Post findById(Long id) {
        var post = postRespository.findById(id);
        if (post.isEmpty())
            new IllegalArgumentException("This account does not exists");
        return post.get();
    }
}
