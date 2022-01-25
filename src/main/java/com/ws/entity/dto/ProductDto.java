package com.ws.entity.dto;

import com.ws.entity.CategoryEntity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private CategoryEntity category;
    private BigDecimal price;
    private int status;
}
