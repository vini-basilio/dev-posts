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
    public Post createPost(PostCreateDTO post, Long id) {
        var user = userService.findById(id);
        var postToSave = new Post();

        postToSave.setPost(post.getPost());
        postToSave.setTitle(post.getTitle());
        postToSave.setUser(user);

        return postRespository.save(postToSave);
    }

}
