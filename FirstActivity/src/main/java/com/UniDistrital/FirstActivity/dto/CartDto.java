package com.UniDistrital.FirstActivity.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private int id;
    private int userId;
    private String date;
    private List<CartProduct> products;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CartProduct {
        @JsonProperty("productId")
        private int productId;
        private int quantity;
    }
}