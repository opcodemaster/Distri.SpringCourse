package com.UniDistrital.FirstActivity.models;

import com.UniDistrital.FirstActivity.dto.ProductDTO;

import lombok.Data;

/**
 * Representa un producto en la lógica de negocio.
 */
@Data
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private double ratingRate;     
    private int ratingCount;         
    
    public Product(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();  
        this.description = productDTO.getDescription();
        this.category = productDTO.getCategory();
        this.imageUrl = productDTO.getImageUrl();
        this.ratingRate = productDTO.getRating().getRate();
        this.ratingCount = productDTO.getRating().getCount();
    }
}