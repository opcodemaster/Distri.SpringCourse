package com.UniDistrital.FirstActivity.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UniDistrital.FirstActivity.dto.CartDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService implements ICartService{

    private final RestTemplate restTemplate;
    private final String urlOfSerive = "https://fakestoreapi.com/carts/";

    @Override
    public CartDTO fetchCarByUserId(Long userID) {
        return restTemplate.getForObject(urlOfSerive + userID, CartDTO.class);
    }
}
