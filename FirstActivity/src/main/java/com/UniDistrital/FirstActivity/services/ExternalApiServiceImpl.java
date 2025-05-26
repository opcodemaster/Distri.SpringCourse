package com.UniDistrital.FirstActivity.services;

import com.UniDistrital.FirstActivity.dto.LoginRequestDto;
import com.UniDistrital.FirstActivity.dto.LoginResponseDto;
import com.UniDistrital.FirstActivity.dto.ProductDto;
import com.UniDistrital.FirstActivity.models.Cart;
import com.UniDistrital.FirstActivity.dto.CartDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://fakestoreapi.com";

    public ExternalApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   @Override
public LoginResponseDto login(LoginRequestDto credentials) {
    String url = BASE_URL + "/auth/login";
    try {
        return restTemplate.postForObject(url, credentials, LoginResponseDto.class);
    } catch (HttpClientErrorException e) {
        
        throw new RuntimeException("Credenciales inválidas");
    }
}



    @Override
    public List<ProductDto> fetchAllProducts() {
        String url = BASE_URL + "/products";
        ProductDto[] arr = restTemplate.getForObject(url, ProductDto[].class);
        return Arrays.asList(arr != null ? arr : new ProductDto[0]);
    }

    @Override
    public List<CartDto> fetchCartsByUser(int userId) {
        String url = BASE_URL + "/carts/user/" + userId;
        CartDto[] arr = restTemplate.getForObject(url, CartDto[].class);
        return Arrays.asList(arr != null ? arr : new CartDto[0]);
    }
     @Override
    public List<Cart> fetchCartsByUserAsDomain(int userId) {
         List<CartDto> cartDtos = fetchCartsByUser(userId);
        return cartDtos.stream()
        .map(Cart::new) 
        .collect(Collectors.toList());
}

     @Override
     public ProductDto fecthProductById(int productId) {
       String url = BASE_URL + "/products/" + productId;
    try {
        return restTemplate.getForObject(url, ProductDto.class);
    } catch (HttpClientErrorException e) {
        throw new RuntimeException("No se encontró el producto con ID " + productId);
    }
     }
  


}