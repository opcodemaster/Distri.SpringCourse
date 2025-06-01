package com.UniDistrital.FirstActivity.services;

import java.util.List;

import com.UniDistrital.FirstActivity.dto.ProductDTO;

public interface IProductService {
    ProductDTO fechProductByID(int productID);
    List<ProductDTO> fetchAllProductsList();
}
