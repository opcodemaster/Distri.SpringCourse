package com.UniDistrital.FirstActivity.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UniDistrital.FirstActivity.dto.LoginRequestDTO;
import com.UniDistrital.FirstActivity.dto.LoginResponseDTO;
import com.UniDistrital.FirstActivity.dto.UserDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final RestTemplate restTemplate;
    private final AuthService authService;
    private final String urlOfService = "https://fakestoreapi.com/users/";

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        List<UserDTO> users = fetchAllUsers();
    
        return users.stream()
            .filter(user -> 
                user.getUsername().equals(request.getUsername()) &&
                user.getPassword().equals(request.getPassword()))
            .findFirst()
            .map(user -> LoginResponseDTO.builder()
            .id(user.getId())
            .build())
            .orElseThrow(() -> new RuntimeException("Usuario o contraseña incorrectos"));
    }    

    @Override
    public List<UserDTO> fetchAllUsers() {
        UserDTO[] users = restTemplate.getForObject(urlOfService, UserDTO[].class);
        return Arrays.asList(users);
    }
}