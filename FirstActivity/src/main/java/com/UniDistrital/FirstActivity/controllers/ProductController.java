package com.UniDistrital.FirstActivity.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.UniDistrital.FirstActivity.dto.ProductDto;
import com.UniDistrital.FirstActivity.services.ProductService;
import com.UniDistrital.FirstActivity.services.ExternalApiService;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping
    public String listProducts(Model model) {
        List<ProductDto> products = productService.fetchAllProducts();
        model.addAttribute("products", products);
        return "products";   // templates/products.html
    }

    @GetMapping("/{productID}")
    public String showProduct(
            @PathVariable int productID,
            Model model
    ) {
        ProductDto product = productService.fetchProductById(productID);
        model.addAttribute("product", product);
        return "product-detail";    // Thymeleaf: src/main/resources/templates/product-detail.html
    }
}