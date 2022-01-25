package com.ws.service;

import com.ws.entity.dto.CaterogyDto;

import java.util.List;

public interface CategoryService {

    List<CaterogyDto> findAllCategory();
    CaterogyDto saveCategory(CaterogyDto caterogyDto);


}
