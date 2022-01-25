package com.ws.app;

import com.ws.entity.dto.CustomerDto;
import com.ws.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ws/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    @PostMapping
    public CustomerDto save(@RequestBody @Valid CustomerDto customer){
        return customerService.saveCustomer(customer);
    }
}

