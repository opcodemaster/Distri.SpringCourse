package com.UniDistrital.FirstActivity.services;

import com.UniDistrital.FirstActivity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UniDistrital.FirstActivity.models.UserDTO;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        return userRepository.save(userDTO);
    }
}