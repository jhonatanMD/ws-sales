package com.ws.service;

import com.ws.entity.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll(int page , int size);
    ProductDto saveProduct(ProductDto product);
}
