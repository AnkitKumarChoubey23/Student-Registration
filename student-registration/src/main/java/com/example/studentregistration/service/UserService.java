package com.example.studentregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentregistration.model.User;
import com.example.studentregistration.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // Validate login
    public User validateUser(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    // Save new user
    public void saveUser(User user) {
        repository.save(user);
    }

    // ✅ ADD THIS METHOD
    public boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}
