package com.ws.app;

import com.ws.entity.dto.OrderDto;
import com.ws.entity.dto.StatusRequest;
import com.ws.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

   @GetMapping("/{page}/{size}")
    public List<OrderDto> findAll(@PathVariable  int page,@PathVariable int size){
        return orderService.findAll(page,size);
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDto save(@RequestBody OrderDto order){
        return orderService.saveOrder(order);
    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto order){
        return orderService.updateOrder(order);
    }

    @PutMapping("/status")
    public OrderDto updateStatus(@PathVariable StatusRequest request){
        return orderService.updateStatus(request);
    }


}
