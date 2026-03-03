package com.example.studentregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentregistration.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
