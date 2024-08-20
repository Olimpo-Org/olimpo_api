package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
