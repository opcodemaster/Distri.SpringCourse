package com.UniDistrital.FirstActivity.services;

import com.UniDistrital.FirstActivity.dto.CartDTO;

public interface  ICartService {
    CartDTO fetchCarByUserId(Long userID);
}
