package com.company.solace.data.service;

import com.company.solace.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(@Autowired CustomerRepository repository) {
        this.repository = repository;
    }


    // Logic here

    protected CustomerRepository getRepository() {
        return repository;
    }
}
