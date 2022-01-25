package com.ws.app;

import com.ws.entity.dto.OrderDto;
import com.ws.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ws/order")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

   @GetMapping
    public List<OrderDto> findAll(){
        return orderService.findAll();
    }


    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto order){
        return orderService.saveOrder(order);
    }
}
