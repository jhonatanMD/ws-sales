package com.ws.service;

import com.ws.entity.dto.OrderDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);
    List<OrderDto> findAll(int page,int size);
    OrderDto findById(Long id);
    OrderDto updateOrder(OrderDto order);



}
