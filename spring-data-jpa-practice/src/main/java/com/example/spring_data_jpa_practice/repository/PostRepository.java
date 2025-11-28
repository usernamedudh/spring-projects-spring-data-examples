package com.example.spring_data_jpa_practice.repository;

import com.example.spring_data_jpa_practice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);
}
