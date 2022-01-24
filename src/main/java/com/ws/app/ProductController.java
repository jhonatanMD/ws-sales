package com.ws.app;


import com.ws.entity.ProductEntity;
import com.ws.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ws/product")
public class ProductController {

    private final ProductRepository repository;


    @GetMapping
    public List<ProductEntity> findAll(){

        return repository.findAll();
    }
}
