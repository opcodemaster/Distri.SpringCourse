package com.UniDistrital.FirstActivity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UniDistrital.FirstActivity.models.ProductDTO;

@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;

    public ProductDTO fetchProducts(int productID) {
        String url = "https://fakestoreapi.com/products/".concat(String.valueOf(productID));
        return restTemplate.getForObject(url, ProductDTO.class);
    }
}
