package com.ws.entity;

import com.ws.entity.dto.PaidTaxes;
import com.ws.util.StatusOrder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;

    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taxes_id", referencedColumnName = "taxes_id")
    private TaxesEntity taxes;

    @Embedded
    private PaidTaxes paidTaxes;

    @OneToOne(fetch = FetchType.EAGER)
    private CustomerEntity customer;


    private BigDecimal subTotal;
    private BigDecimal total;

}
