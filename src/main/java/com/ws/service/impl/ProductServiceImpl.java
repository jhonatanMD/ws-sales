package com.ws.service.impl;

import com.ws.entity.dto.ProductDto;
import com.ws.repository.ProductRepository;
import com.ws.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        return null;
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
        return null;
    }
}
