package com.UniDistrital.FirstActivity.controllers;

import java.net.http.HttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UniDistrital.FirstActivity.models.UserDTO;
import com.UniDistrital.FirstActivity.services.UserService;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void postMethodName(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }
}