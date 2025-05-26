package com.UniDistrital.FirstActivity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un producto en la lógica de negocio.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private String category;
    private String imageUrl;
    private double price;
    private double ratingValue;     
    private int ratingCount;         

    
    public Product(com.UniDistrital.FirstActivity.dto.ProductDto dto) {
        this.id          = dto.getId();
        this.name        = dto.getName();
        this.description = dto.getDescription();
        this.category    = dto.getCategory();
        this.imageUrl    = dto.getImageUrl();
        
        Object rateObj  = dto.getRating().get("rate");
        Object countObj = dto.getRating().get("count");
        this.ratingValue = rateObj instanceof Number ? ((Number) rateObj).doubleValue() : 0.0;
        this.ratingCount = countObj instanceof Number ? ((Number) countObj).intValue()    : 0;
        this.price       = dto.getPrice();  
    }
}