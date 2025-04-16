package edu.blog.dev_posts.service;

import java.util.List;

import edu.blog.dev_posts.domain.DTOs.UserCreateDTO;
import edu.blog.dev_posts.domain.model.User;

public interface UserService {
    User findById(Long id);

    Void delete(Long id);

    User create(UserCreateDTO userToCreate);

    List<User> getAll();
}
