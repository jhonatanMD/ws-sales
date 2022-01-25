package com.ws.mapper;

import com.ws.entity.CategoryEntity;
import com.ws.entity.dto.CaterogyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CaterogyDto toDto(CategoryEntity entity);
    CategoryEntity toEntity(CaterogyDto categoryDto);
}
