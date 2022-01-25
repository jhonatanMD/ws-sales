package com.ws;

import com.ws.entity.CategoryEntity;
import com.ws.entity.CustomerEntity;
import com.ws.entity.ProductEntity;
import com.ws.entity.TaxesEntity;
import com.ws.repository.CategoryRepository;
import com.ws.repository.CustomerRepository;
import com.ws.repository.ProductRepository;
import com.ws.repository.TaxesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@SpringBootApplication
public class WsSalesApplication {


    private final  CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final TaxesRepository taxesRepository;

    public static void main(String[] args) {
        SpringApplication.run(WsSalesApplication.class, args);
    }



    @Bean
     void run() {

        categoryRepository.save(new CategoryEntity(1l,"GASEOSA"));
        categoryRepository.save(new CategoryEntity(2l,"COMESTIBLES"));
        customerRepository.save(new CustomerEntity(1l,"Jhonatan"));
        productRepository.save(new ProductEntity(1L,"COCA COLA",new CategoryEntity(1L,""),new BigDecimal(50),0));
        productRepository.save(new ProductEntity(2L,"CHISTRIS",new CategoryEntity(2L,""),new BigDecimal(50),0));
        taxesRepository.save(new TaxesEntity(1l,BigDecimal.valueOf(10),BigDecimal.valueOf(5),BigDecimal.valueOf(8),BigDecimal.valueOf(2)));

    }

}
