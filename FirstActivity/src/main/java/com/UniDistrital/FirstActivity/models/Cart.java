package com.UniDistrital.FirstActivity.models;

import java.util.List;
import java.util.stream.Collectors;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import com.UniDistrital.FirstActivity.dto.CartDTO;
import com.UniDistrital.FirstActivity.services.ProductService;

@Data
public class Cart {
    private int id;
    private int userId;
    private String date;
    private List<Product> products;
    private List<ProductDetails> productsDetails;

    public void setDetailsOfArticles(ProductService productService) {
        this.productsDetails = this.products.stream()
        .map(p -> {
            var product = productService.fechProductByID(p.getProductId());
            if (product == null) {
                return null;
            }
            return ProductDetails.builder()
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
        })
        .filter(p -> p != null)
        .collect(Collectors.toList());
    }

    public Cart(CartDTO cartDTO, ProductService productService) {
        this.id = cartDTO.getId();
        this.userId = cartDTO.getUserId();
        this.date = cartDTO.getDate();

        this.products = cartDTO.getProducts().stream()
            .map(p -> Product.builder()
                    .productId(p.getProductId())
                    .quantity(p.getQuantity())
                    .build())
            .collect(Collectors.toList());

        setDetailsOfArticles(productService);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {
        private int productId;
        private int quantity;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDetails {
        private String name;
        private String description;
        private String category;
        private Double price;
        private String imageUrl;
    }
}