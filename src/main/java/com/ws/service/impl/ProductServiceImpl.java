package com.ws.service.impl;

import com.ws.entity.dto.ProductDto;
import com.ws.mapper.ProductMapper;
import com.ws.repository.ProductRepository;
import com.ws.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll(int page , int size) {
        Pageable pageable = PageRequest.of(page,size);
        return productRepository.findAll(pageable)
                .map(productMapper::toDto)
                .getContent();
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
        return null;
    }
}
