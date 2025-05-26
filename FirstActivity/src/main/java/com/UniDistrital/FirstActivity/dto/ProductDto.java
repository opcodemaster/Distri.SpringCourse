package com.UniDistrital.FirstActivity.dto;

import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    @JsonProperty("title")
    private String name;
    private String description;
    private String category;
    private Double price;
    @JsonProperty("image")
    private String imageUrl;
    private TreeMap<String, Object> rating;
}
