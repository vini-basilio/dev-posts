package edu.blog.dev_posts.domain.repository;

import java.util.List;

import edu.blog.dev_posts.domain.roles.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.blog.dev_posts.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);
    List<User> findByRole(UserRole role);
    User findByLogin(String login);
}
