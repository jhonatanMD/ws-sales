package com.ws.service.impl;

import com.ws.entity.CategoryEntity;
import com.ws.repository.CategoryRepository;
import com.ws.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAllCategory() {
        return categoryRepository.findAll();
    }
}
