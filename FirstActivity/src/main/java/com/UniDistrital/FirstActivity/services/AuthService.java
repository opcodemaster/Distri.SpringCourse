package com.UniDistrital.FirstActivity.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UniDistrital.FirstActivity.dto.LoginRequestDTO;
import com.UniDistrital.FirstActivity.dto.LoginResponseDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService{

    private final RestTemplate restTemplate;
    private final String urlOfService = "https://fakestoreapi.com/auth/login";

    @Override
    public LoginResponseDTO getTokenByCredentials(LoginRequestDTO request) {
        return restTemplate.postForObject(urlOfService, request, LoginResponseDTO.class);
    }
}