package com.ws;

import com.ws.entity.CategoryEntity;
import com.ws.entity.OrderEntity;
import com.ws.entity.OrderProductEntity;
import com.ws.entity.ProductEntity;
import com.ws.entity.TaxesEntity;
import com.ws.repository.CategoryRepository;
import com.ws.repository.OrderProductRepository;
import com.ws.repository.OrderRepository;
import com.ws.repository.ProductRepository;
import com.ws.repository.TaxesRepository;
import com.ws.util.StatusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;


@SpringBootApplication
public class WsSalesApplication {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private TaxesRepository taxesRepository;

    public static void main(String[] args) {
        SpringApplication.run(WsSalesApplication.class, args);
    }



    @Bean
     void run() {

        categoryRepository.save(new CategoryEntity(1l,"GASEOSA"));
        categoryRepository.save(new CategoryEntity(2l,"COMESTIBLES"));
        productRepository.save(new ProductEntity(1L,"COCA COLA",new CategoryEntity(1L,""),new BigDecimal(12),1));
        productRepository.save(new ProductEntity(2L,"CHISTRIS",new CategoryEntity(2L,""),new BigDecimal(12),1));
        taxesRepository.save(new TaxesEntity(1l,BigDecimal.valueOf(10),BigDecimal.valueOf(5),BigDecimal.valueOf(8),BigDecimal.valueOf(2)));

    }

}
