package com.UniDistrital.FirstActivity.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;


@Data
public class LoginRequestDto {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}