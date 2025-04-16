package edu.blog.dev_posts.service.imp;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.blog.dev_posts.domain.DTOs.UserCreateDTO;
import edu.blog.dev_posts.domain.model.User;
import edu.blog.dev_posts.domain.repository.UserRespository;
import edu.blog.dev_posts.service.UserService;

@Service
public class UserServiceImp implements UserService {
    private final UserRespository userRespository;

    public UserServiceImp(UserRespository respository) {
        this.userRespository = respository;
    }

    @Override
    public User findById(Long id) {
        return userRespository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(UserCreateDTO userToCreate) {
        if (userRespository.existsByLogin(userToCreate.getLogin())) {
            throw new IllegalArgumentException("This account login already exists");
        }
        var userToSave = new User();
        userToSave.setLogin(userToCreate.getLogin());
        userToSave.setName(userToCreate.getName());
        return userRespository.save(userToSave);
    }

}
