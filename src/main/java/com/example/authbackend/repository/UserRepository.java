package com.example.authbackend.repository;

import com.example.authbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsernameAndPassword(String username, String password);
}
