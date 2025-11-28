package com.example.spring_data_jpa_practice.controller;

import com.example.spring_data_jpa_practice.entity.Post;
import com.example.spring_data_jpa_practice.entity.User;
import com.example.spring_data_jpa_practice.service.UserPostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserPostController {

    private final UserPostService service;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/users/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return service.getUsersByName(name);
    }

    @GetMapping("/users/domain/{domain}")
    public List<User> getUsersByEmailDomain(@PathVariable String domain) {
        return service.getUsersByEmailDomain(domain);
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return service.getPostsByUserId(userId);
    }

    @PostMapping("/users-with-post")
    public void createUserWithPost(@RequestBody UserPostRequest request) {
        service.createUserWithPost(request.getUser(), request.getPost());
    }


    @Data
    public static class UserPostRequest {
        private User user;
        private Post post;
    }
}
