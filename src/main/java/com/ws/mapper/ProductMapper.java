package com.ws.mapper;

import com.ws.entity.ProductEntity;
import com.ws.entity.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity (ProductDto productDto);
}
