package com.ws.entity.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CaterogyDto {
    private Long id;
    @NotNull
    private String name;
}
