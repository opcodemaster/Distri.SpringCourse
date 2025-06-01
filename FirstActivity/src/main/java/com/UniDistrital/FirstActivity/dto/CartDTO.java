package com.UniDistrital.FirstActivity.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CartDTO {
    private int id;
    private int userId;
    private String date;
    private List<CartProduct> products;

    @Data
    @Builder
    public static class CartProduct {
        private int productId;
        private int quantity;
    }
}