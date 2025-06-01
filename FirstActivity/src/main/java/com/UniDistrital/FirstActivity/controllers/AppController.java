package com.UniDistrital.FirstActivity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.UniDistrital.FirstActivity.dto.LoginRequestDTO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AppController {
    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDTO());
        return "index";
    }
}