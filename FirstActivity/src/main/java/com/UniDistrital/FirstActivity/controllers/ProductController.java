package com.UniDistrital.FirstActivity.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UniDistrital.FirstActivity.dto.ProductDTO;
import com.UniDistrital.FirstActivity.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> products = productService.fetchAllProductsList();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/GetProductById/{productID}")
    public ResponseEntity<ProductDTO> showProduct(@PathVariable int productID) {
        ProductDTO product = productService.fechProductByID(productID);
        return ResponseEntity.ok(product);
    }
}