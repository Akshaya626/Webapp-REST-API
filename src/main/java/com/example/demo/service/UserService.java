package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve User by Email
    public User getUserByEmailId(String emailId) {
        return userRepository.findByEmailId(emailId);
    }

    // Update User
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmailId(userDetails.getEmailId());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        });
    }

    // Delete User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
