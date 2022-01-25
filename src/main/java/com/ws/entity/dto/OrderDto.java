package com.ws.entity.dto;

import com.ws.entity.CustomerEntity;
import com.ws.entity.OrderProductEntity;
import com.ws.entity.TaxesEntity;
import com.ws.util.StatusOrder;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String orderId;
    private StatusOrder statusOrder;
    private LocalDate date;
    private TaxesEntity taxes;
    private PaidTaxes paidTaxes;
    private CustomerEntity customer;
    private List<OrderProductEntity> orderProducts;
    private BigDecimal subTotal;
    private BigDecimal total;

}
