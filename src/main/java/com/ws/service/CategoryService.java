package com.ws.service;

import com.ws.entity.CategoryEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAllCategory();


}
