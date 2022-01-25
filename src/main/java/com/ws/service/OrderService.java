package com.ws.service;

import com.ws.entity.dto.OrderDto;
import com.ws.entity.dto.StatusRequest;

import java.util.List;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);
    List<OrderDto> findAll(int page,int size);
    OrderDto findById(Long id);
    OrderDto updateOrder(OrderDto order);
    OrderDto updateStatus(StatusRequest request);



}
