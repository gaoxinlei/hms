package com.example.hms.mapper;

import com.example.hms.model.Customer;

public interface CustomerMapper {
    Customer selectCustomerByNumber(String number);

    int insert(Customer customer);
}
