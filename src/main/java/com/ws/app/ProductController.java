package com.ws.app;

import com.ws.entity.dto.ProductDto;
import com.ws.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ws/product")
public class ProductController {


    private final ProductService productService;

    @GetMapping("/{page}/{size}")
    public List<ProductDto> findAll(@PathVariable int page, @PathVariable int size){
      return productService.findAll(page,size);
    }
}
