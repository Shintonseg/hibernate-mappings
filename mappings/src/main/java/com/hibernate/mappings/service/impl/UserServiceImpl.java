package com.hibernate.mappings.service.impl;

import com.hibernate.mappings.model.User;
import com.hibernate.mappings.repository.UserRepository;
import com.hibernate.mappings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setProfile(userDetails.getProfile());
            return userRepository.save(user);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
