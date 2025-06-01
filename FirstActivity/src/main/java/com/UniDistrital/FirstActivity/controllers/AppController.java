package com.UniDistrital.FirstActivity.controllers;

import com.UniDistrital.FirstActivity.dto.LoginRequestDto;
import com.UniDistrital.FirstActivity.dto.LoginResponseDto;
import com.UniDistrital.FirstActivity.dto.ProductDto;
import com.UniDistrital.FirstActivity.models.Cart;
import com.UniDistrital.FirstActivity.services.ExternalApiService;  

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    private final ExternalApiService apiService;

    public AppController(ExternalApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDto());
        return "index";  // src/main/resources/templates/index.html
    }

    @PostMapping("/login")
    public String doLogin(
            @Validated @ModelAttribute("loginRequest") LoginRequestDto form,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "index";
        }

        try {
            LoginResponseDto response = apiService.login(form);
    
            List<ProductDto> products = apiService.fetchAllProducts();
            model.addAttribute("products", products);
            return "products";  
        } catch (Exception e) {
            model.addAttribute("loginRequest", form);
            model.addAttribute("errorMessage", e.getMessage());
            return "index";
        }
    }

    @GetMapping("/carts/{userId}")
    public String carts(@PathVariable int userId, Model model) {
        List<Cart> carts = apiService.fetchCartsByUserAsDomain(userId);
        model.addAttribute("carts", carts);
        return "carts";
    }
}

