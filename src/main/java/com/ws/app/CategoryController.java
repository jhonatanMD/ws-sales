package com.ws.app;

import com.ws.entity.CategoryEntity;
import com.ws.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ws/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public List<CategoryEntity> findAllCategory(){
        return categoryService.findAllCategory();
    }

}
