package com.ws.service;

import com.ws.entity.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto saveCustomer(CustomerDto customerDto);
}
