package com.UniDistrital.FirstActivity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import com.UniDistrital.FirstActivity.dto.ProductDto;

@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;

    public ProductDto fetchProducts(int productID) {
        String url = "https://fakestoreapi.com/products/".concat(String.valueOf(productID));
        return restTemplate.getForObject(url, ProductDto.class);
    }
    public ProductDto fetchProductById(int productID) {
        String url = "https://fakestoreapi.com/products/" + productID;
        return restTemplate.getForObject(url, ProductDto.class);
    }

     public List<ProductDto> fetchAllProducts() {
        String url = "https://fakestoreapi.com/products";
        ProductDto[] arr = restTemplate.getForObject(url, ProductDto[].class);
        return Arrays.asList(arr != null ? arr : new ProductDto[0]);
    }
}
