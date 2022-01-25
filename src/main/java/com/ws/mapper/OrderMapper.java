package com.ws.mapper;

import com.ws.entity.OrderEntity;
import com.ws.entity.OrderProductEntity;
import com.ws.entity.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    OrderEntity toEntity(OrderDto orderRequest);

    OrderDto toDto (OrderEntity orderEntity);


    default OrderDto match(OrderEntity orderEntity , List<OrderProductEntity> orderProductEntity){

        OrderDto orderDto = toDto(orderEntity);
        orderDto.setOrderProducts(orderProductEntity);
        return orderDto;
    }



}
