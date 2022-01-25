package com.ws.app;

import com.ws.entity.dto.CaterogyDto;
import com.ws.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ws/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public List<CaterogyDto> findAll(){
        return categoryService.findAllCategory();
    }

    @PostMapping
    public CaterogyDto save(@RequestBody @Valid  CaterogyDto caterogyDto)
    {
        return categoryService.saveCategory(caterogyDto);
    }

}
