package com.UniDistrital.FirstActivity.services;

import com.UniDistrital.FirstActivity.dto.LoginRequestDto;
import com.UniDistrital.FirstActivity.dto.LoginResponseDto;
import com.UniDistrital.FirstActivity.dto.ProductDto;
import com.UniDistrital.FirstActivity.models.Cart;
import com.UniDistrital.FirstActivity.dto.CartDto;
import java.util.List;

public interface ExternalApiService {

    
    LoginResponseDto login(LoginRequestDto credentials);
    List<ProductDto> fetchAllProducts();
    ProductDto fecthProductById(int productId);
    List<CartDto> fetchCartsByUser(int userId);
    List<Cart> fetchCartsByUserAsDomain(int userId);
}
