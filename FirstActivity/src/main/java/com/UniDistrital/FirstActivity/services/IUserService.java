package com.UniDistrital.FirstActivity.services;

import java.util.List;

import com.UniDistrital.FirstActivity.dto.LoginRequestDTO;
import com.UniDistrital.FirstActivity.dto.LoginResponseDTO;
import com.UniDistrital.FirstActivity.dto.UserDTO;

public abstract interface IUserService {
    LoginResponseDTO login(LoginRequestDTO request);
    List<UserDTO> fetchAllUsers();
}