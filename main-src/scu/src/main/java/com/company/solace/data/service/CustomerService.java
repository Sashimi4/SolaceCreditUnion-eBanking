package com.company.solace.data.service;

import com.company.solace.data.entity.Customer;
import com.company.solace.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerService() {
    }

    /**
     *
     * @param customer
     */
    public void saveCustomer(Customer customer){
        getRepository().save(customer);
    }


    private CustomerRepository getRepository() {
        return repository;
    }
}
