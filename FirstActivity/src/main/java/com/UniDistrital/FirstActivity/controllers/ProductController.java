package com.UniDistrital.FirstActivity.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UniDistrital.FirstActivity.models.ProductDTO;
import com.UniDistrital.FirstActivity.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productID}")
    public String getProductByID(@PathVariable int productID) {
        ProductDTO product = productService.fetchProducts(productID);
        return product != null ? product.getName() : "Producto no encontrado";
    }
}