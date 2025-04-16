package edu.blog.dev_posts.service;

import edu.blog.dev_posts.domain.DTOs.UserCreateDTO;
import edu.blog.dev_posts.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(UserCreateDTO userToCreate);
}
