package com.ws.app;

import com.ws.entity.OrderEntity;
import com.ws.entity.OrderProductEntity;
import com.ws.entity.dto.PaidTaxes;
import com.ws.repository.OrderProductRepository;
import com.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@RequestMapping("/ws/order")
public class OrderController {


    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @GetMapping
    public List<OrderEntity> findAll(){
        return repository.findAll();
    }


    @PostMapping
    public OrderEntity saveOrder(@RequestBody OrderEntity order){

        OrderEntity orderEntity = repository.save(order);


        orderEntity.getOrderProducts().forEach(p -> {
            orderEntity.setSubTotal(orderEntity.getSubTotal().add(p.getProductEntity().getPrice()));
        });


        BigDecimal amount;

        BigDecimal desc1 = orderEntity.getSubTotal().multiply(orderEntity.getTaxes().getMunicipalPercentage()).divide(BigDecimal.valueOf(100));
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


        System.out.println(amount);

        return repository.save(orderEntity);
    }
}
