package com.UniDistrital.FirstActivity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.UniDistrital.FirstActivity.dto.CartDTO;
import com.UniDistrital.FirstActivity.models.Cart;
import com.UniDistrital.FirstActivity.services.CartService;
import com.UniDistrital.FirstActivity.services.ProductService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/cart")
    public String getCartByUserID(Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("userID");
        if (userID == null) {
            return "redirect:/";
        }

        CartDTO cartDTO = cartService.fetchCarByUserId(userID);
        Cart cart = new Cart(cartDTO, productService);
        model.addAttribute("cart", cart);
        return "cart";
    }
}
