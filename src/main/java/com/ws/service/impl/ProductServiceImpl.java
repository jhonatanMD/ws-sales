package com.ws.service.impl;

import com.ws.entity.dto.ProductDto;
import com.ws.mapper.ProductMapper;
import com.ws.repository.ProductRepository;
import com.ws.service.ProductService;
import com.ws.util.StatusProduct;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        product.setStatus(StatusProduct.ACTIVED.getCode());
        return saveAndUpdate(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        return saveAndUpdate(product);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.findById(id)
                .map(p -> {
                    p.setStatus(StatusProduct.DELETED.getCode());
                    return productRepository.save(p);
                });
    }


    private ProductDto saveAndUpdate(ProductDto product){
        return Optional.of(product)
                .map(productMapper::toEntity)
                .map(productRepository::save)
                .map(productMapper::toDto)
                .get();
    }
}
