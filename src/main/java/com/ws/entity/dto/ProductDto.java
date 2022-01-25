package com.ws.entity.dto;

import com.ws.entity.CategoryEntity;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @NotNull
    private CategoryEntity category;
    @NotNull
    private BigDecimal price;

    private int status;
}
