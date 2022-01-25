package com.ws.service;

import com.ws.entity.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto saveProduct(ProductDto product);
}
