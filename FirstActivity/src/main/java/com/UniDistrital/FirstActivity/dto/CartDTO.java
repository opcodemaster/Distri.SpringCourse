package com.UniDistrital.FirstActivity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private int id;
    private int userId;
    private String date;
    private List<Products> products;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Products {
        private int productId;
        private int quantity;
    }
}