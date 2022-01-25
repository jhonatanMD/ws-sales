package com.ws.repository;

import com.ws.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity,Long> {

    List<OrderProductEntity> findByOrderOrderId(String orderId);
}
