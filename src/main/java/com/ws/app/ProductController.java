package com.ws.app;

import com.ws.entity.dto.ProductDto;
import com.ws.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ws/product")
public class ProductController {


    private final ProductService productService;

    @Valid
    @GetMapping("/{page}/{size}")
    public List<ProductDto> findAll(@PathVariable @NotNull int page, @NotNull @PathVariable int size){
      return productService.findAll(page,size);
    }


    @PostMapping
    public ProductDto save(@RequestBody @Valid ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody @Valid ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Valid @NotNull Long id){
        productService.deleteProduct(id);
    }
}
