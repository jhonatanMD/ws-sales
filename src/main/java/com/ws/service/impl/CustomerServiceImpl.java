package com.ws.service.impl;

import com.ws.entity.dto.CustomerDto;
import com.ws.mapper.CustomerMapper;
import com.ws.repository.CustomerRepository;
import com.ws.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll()
                .stream().map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return Optional.of(customerDto)
                .map(customerMapper::toEntity)
                .map(customerRepository::save)
                .map(customerMapper::toDto)
                .get();
    }
}
