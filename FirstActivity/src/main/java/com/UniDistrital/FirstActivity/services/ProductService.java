package com.UniDistrital.FirstActivity.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UniDistrital.FirstActivity.dto.ProductDTO;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final RestTemplate restTemplate;
    private final String urlOfService = "https://fakestoreapi.com/products";

    @Override
    public ProductDTO fechProductByID(int productID) {
        return restTemplate.getForObject(urlOfService + productID, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> fetchAllProductsList() {
        ProductDTO[] arr = restTemplate.getForObject(urlOfService, ProductDTO[].class);
        return Arrays.asList(arr != null ? arr : new ProductDTO[0]);
    }
}
