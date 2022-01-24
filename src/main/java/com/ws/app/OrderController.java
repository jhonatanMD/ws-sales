package com.ws.app;

import com.ws.entity.OrderEntity;
import com.ws.repository.OrderProductRepository;
import com.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ws/order")
public class OrderController {


    @Autowired
    private OrderRepository repository;
    @GetMapping
    public List<OrderEntity> findAll(){
        return repository.findAll();
    }
}
