package edu.blog.dev_posts.controller;

import edu.blog.dev_posts.domain.DTOs.WriterCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.blog.dev_posts.domain.DTOs.AuthenticationDto;
import edu.blog.dev_posts.domain.DTOs.LoginResponseDto;
import edu.blog.dev_posts.domain.DTOs.UserCreateDTO;

import edu.blog.dev_posts.service.UserService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(userService.getAllWriters());
    }
    @PostMapping("/register/writer")
    public ResponseEntity<Void> registerWriter(@Valid @RequestBody WriterCreateDTO user) {
        userService.registerWriters(user);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/register/reader")
    public ResponseEntity<Void> registerReader(@Valid @RequestBody UserCreateDTO user) {
        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody AuthenticationDto authenticationDto) {
        String token = userService.login(authenticationDto);
        return ResponseEntity.status(201).body(new LoginResponseDto(token));
    }
}
