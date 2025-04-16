package edu.blog.dev_posts.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.blog.dev_posts.domain.model.Post;

public interface PostRespository extends JpaRepository<Post, Long> {

}
