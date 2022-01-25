package com.ws.service.impl;

import com.ws.entity.dto.CaterogyDto;
import com.ws.mapper.CategoryMapper;
import com.ws.repository.CategoryRepository;
import com.ws.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CaterogyDto> findAllCategory() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CaterogyDto saveCategory(CaterogyDto caterogyDto) {
        return Optional.of(caterogyDto)
                .map(categoryMapper::toEntity)
                .map(categoryRepository::save)
                .map(categoryMapper::toDto)
                .get();
    }
}
