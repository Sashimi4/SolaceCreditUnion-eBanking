package com.company.solace.data.service;

import com.company.solace.data.entity.Customer;
import com.company.solace.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerService() {
    }


    public void saveCustomer(Customer customer){
        System.out.println("customer : " + customer.toString());
        getRepository().save(customer);
    }


    private CustomerRepository getRepository() {
        return repository;
    }
}
