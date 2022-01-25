package com.ws.mapper;

import com.ws.entity.CustomerEntity;
import com.ws.entity.ProductEntity;
import com.ws.entity.dto.CustomerDto;
import com.ws.entity.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto (CustomerEntity customerEntity);
    CustomerEntity toEntity (CustomerDto customerDto);
}
