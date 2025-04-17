package edu.blog.dev_posts.service;

import java.util.List;

import edu.blog.dev_posts.domain.DTOs.AuthenticationDto;
import edu.blog.dev_posts.domain.DTOs.UserCreateDTO;
import edu.blog.dev_posts.domain.DTOs.UserResponseDto;
import edu.blog.dev_posts.domain.DTOs.WriterCreateDTO;

import edu.blog.dev_posts.domain.model.User;

public interface UserService {
    User findById(Long id);

    User findByLogin(String email);

    Void delete(Long id);

    User create(UserCreateDTO userToCreate);

    List<UserResponseDto> getAllWriters();

    void registerUser(UserCreateDTO user);
    void registerWriters(WriterCreateDTO user);
    String login(AuthenticationDto authenticationDto);

}
