package com.ws.service;

import com.ws.entity.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);
    List<OrderDto> findAll();


}
