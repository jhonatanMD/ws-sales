package com.ws.mapper;

import com.ws.entity.CategoryEntity;
import com.ws.entity.dto.CaterogyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CaterogyResponse toCategory (CategoryEntity entity);
}
