package com.ws.service.impl;

import com.ws.entity.OrderEntity;
import com.ws.entity.dto.OrderDto;
import com.ws.entity.dto.PaidTaxes;
import com.ws.mapper.OrderMapper;
import com.ws.repository.OrderProductRepository;
import com.ws.repository.OrderRepository;
import com.ws.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {



    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    @Override
    public OrderDto saveOrder(OrderDto order) {

        order.setSubTotal(BigDecimal.ZERO);

        OrderEntity orderS =  orderRepository.save(orderMapper.toEntity(order));
        OrderEntity orderEntity  = orderRepository.findById(orderS.getId()).get();

        order.setOrderProducts(order.getOrderProducts().stream().map(p -> {
            p.setOrder(orderEntity);
            return orderProductRepository.save(p);
        }).map(p -> {
            p.setTotal(p.getProductEntity().getPrice().multiply(p.getAmount()));
            orderEntity.setSubTotal(orderEntity.getSubTotal().add(p.getTotal()));
            return orderProductRepository.save(p);

        }).collect(Collectors.toList()));


        BigDecimal amount;

        BigDecimal desc1 = orderEntity.getSubTotal().multiply(orderEntity.getTaxes().getMunicipalPercentage()).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        amount = orderEntity.getSubTotal().add(desc1);
        BigDecimal desc2 = amount.multiply(orderEntity.getTaxes().getCountyPercentage()).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        amount = amount.add(desc2);
        BigDecimal desc3 = amount.multiply(orderEntity.getTaxes().getStatePercentage()).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        amount = amount.add(desc3);
        BigDecimal desc4 =amount.multiply(orderEntity.getTaxes().getFederalPercentage()).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        amount = amount.add(desc4);


        orderEntity.setPaidTaxes(PaidTaxes.builder()
                .municipalTax(desc1)
                .countyTax(desc2)
                .stateTax(desc3)
                .federalTax(desc4)
                .build());

        orderEntity.setTotal(amount.setScale(2, RoundingMode.HALF_UP));



        return orderMapper.match(orderRepository.save(orderEntity),order.getOrderProducts());
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .map(o -> {
                    o.setOrderProducts(orderProductRepository.findByOrderOrderId(o.getOrderId()));
                    return o;
                })
                .collect(Collectors.toList());
    }
}
