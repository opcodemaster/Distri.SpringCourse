package com.UniDistrital.FirstActivity.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.UniDistrital.FirstActivity.dto.LoginRequestDTO;
import com.UniDistrital.FirstActivity.dto.LoginResponseDTO;
import com.UniDistrital.FirstActivity.dto.ProductDTO;
import com.UniDistrital.FirstActivity.services.ProductService;
import com.UniDistrital.FirstActivity.services.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private ProductService productService;
    @PostMapping("/login")
    public String AuthUser(@Validated @ModelAttribute("loginRequest") LoginRequestDTO request, BindingResult result, Model model, HttpSession httpSession) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Alguno de los campos obligatorios está vacío");
            return "index";
        }
        try {
            LoginResponseDTO response = userService.login(request);
            httpSession.setAttribute("userID", response.getId());
            List<ProductDTO> products = productService.fetchAllProductsList();
            model.addAttribute("products", products);
            return "home";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "index";
        }
    }
}