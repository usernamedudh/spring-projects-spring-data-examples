package com.example.spring_data_jpa_practice.service;

import com.example.spring_data_jpa_practice.entity.Post;
import com.example.spring_data_jpa_practice.entity.User;
import com.example.spring_data_jpa_practice.repository.PostRepository;
import com.example.spring_data_jpa_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersByEmailDomain(String domain) {
        return userRepository.findByEmailEndingWith(domain);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Transactional
    public void createUserWithPost(User user, Post post) {
        User savedUser = userRepository.save(user);
        post.setUser(savedUser);
        postRepository.save(post);
    }
}
