package com.UniDistrital.FirstActivity.services;

import com.UniDistrital.FirstActivity.dto.LoginRequestDTO;
import com.UniDistrital.FirstActivity.dto.LoginResponseDTO;

public interface IAuthService {
    LoginResponseDTO getTokenByCredentials(LoginRequestDTO loginRequestDTO);
}