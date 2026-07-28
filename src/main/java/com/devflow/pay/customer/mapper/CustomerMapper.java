package com.devflow.pay.customer.mapper;

import com.devflow.pay.customer.dto.CustomerRequest;
import com.devflow.pay.customer.dto.CustomerResponse;
import com.devflow.pay.customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {

        Customer customer = new Customer();

        customer.setFullName(request.fullName());
        customer.setEmail(request.email());
        customer.setDocument(request.document());
        customer.setPhone(request.phone());
        customer.setActive(true);

        return customer;
    }

    public CustomerResponse toResponse(Customer customer) {

        return new CustomerResponse(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getDocument(),
                customer.getPhone(),
                customer.getActive()
        );
    }

    public void update(Customer customer, CustomerRequest request) {

        customer.setFullName(request.fullName());
        customer.setEmail(request.email());
        customer.setDocument(request.document());
        customer.setPhone(request.phone());

    }

}