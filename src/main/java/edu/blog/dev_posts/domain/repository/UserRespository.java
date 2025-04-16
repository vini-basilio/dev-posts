package edu.blog.dev_posts.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.blog.dev_posts.domain.model.User;

public interface UserRespository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);
}
