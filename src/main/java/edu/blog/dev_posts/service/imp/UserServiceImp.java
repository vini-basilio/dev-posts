package edu.blog.dev_posts.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import edu.blog.dev_posts.domain.DTOs.WriterCreateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.blog.dev_posts.domain.DTOs.AuthenticationDto;
import edu.blog.dev_posts.domain.DTOs.UserCreateDTO;
import edu.blog.dev_posts.domain.DTOs.UserResponseDto;
import edu.blog.dev_posts.domain.model.User;
import edu.blog.dev_posts.domain.repository.UserRepository;
import edu.blog.dev_posts.domain.roles.UserRole;
import edu.blog.dev_posts.security.TokenService;
import edu.blog.dev_posts.service.UserService;

@Service
public class UserServiceImp implements UserService {
    @Value("${api.admin.password}")
    private String secret;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(UserCreateDTO userToCreate) {
        if (userRepository.existsByLogin(userToCreate.getLogin())) {
            throw new IllegalArgumentException("This account login already exists");
        }
        var userToSave = new User();
        userToSave.setLogin(userToCreate.getLogin());
        userToSave.setName(userToCreate.getName());
        userToSave.setRole(UserRole.ADMIN);
        return userRepository.save(userToSave);
    }

    @Override
    public Void delete(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public List<UserResponseDto> getAllWriters() {
        return userRepository.findByRole(UserRole.ADMIN).stream()
                .map(s -> new UserResponseDto(
                s.getId(),
                s.getName(),
                s.getRole(),
                s.getPosts()
                )).toList();
    }

    @Override
    public User findByLogin(String email) {
        var user = userRepository.findByLogin(email);
        if(user == null) throw new NoSuchElementException("USer not found");
        return user;
    }

    @Override
    public void registerUser(UserCreateDTO user) {
        String login = user.getLogin();
        if (userRepository.findByLogin(login) != null) {
            throw new IllegalArgumentException("Login already exists");
        }

        User userToSave = new User();
        userToSave.setLogin(user.getLogin());
        userToSave.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userToSave.setName(user.getName());
        userToSave.setRole(UserRole.USER);

        try {
            User userSaved = userRepository.save(userToSave);

            new UserResponseDto(
                    userSaved.getId(),
                    userSaved.getName(),
                    userSaved.getRole(),
                    userSaved.getPosts());
        } catch (Exception e) {
            throw new RuntimeException("Error while registing");
        }
    }

    @Override
    public void registerWriters(WriterCreateDTO user) {

        String login = user.getLogin();
        if (userRepository.findByLogin(login) != null) {
            throw new IllegalArgumentException("Login already exists");
        }
        if(!user.getAdminPassword().equals(secret)) {
            throw new IllegalArgumentException("Admin password wrong");
        }
        User userToSave = new User();
        userToSave.setLogin(user.getLogin());
        userToSave.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userToSave.setName(user.getName());
        userToSave.setRole(UserRole.ADMIN);

        try {
            User userSaved = userRepository.save(userToSave);

            new UserResponseDto(
                    userSaved.getId(),
                    userSaved.getName(),
                    userSaved.getRole(),
                    userSaved.getPosts());
        } catch (Exception e) {
            throw new RuntimeException("Error while registing");
        }

    }


    @Override
    public String login(AuthenticationDto authenticationDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationDto.login(),
                authenticationDto.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        return tokenService.generateToken((User) auth.getPrincipal());
    }

}
