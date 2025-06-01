package com.UniDistrital.FirstActivity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    @JsonProperty("title")
    private String name;
    private String description;
    private String category;
    private Double price;
    @JsonProperty("image")
    private String imageUrl;
    private Rating rating;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rating {
        private double rate;
        private int count;
    }
}