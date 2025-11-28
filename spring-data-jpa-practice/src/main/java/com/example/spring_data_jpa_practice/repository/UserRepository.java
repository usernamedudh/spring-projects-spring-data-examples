package com.example.spring_data_jpa_practice.repository;


import com.example.spring_data_jpa_practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByEmailEndingWith(String domain);
}
