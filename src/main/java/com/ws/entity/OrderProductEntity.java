package com.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "order_product")
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderEntity order;
    private BigDecimal amount;
    @OneToOne(fetch = FetchType.EAGER)
    private ProductEntity productEntity;
    private BigDecimal total;

}
