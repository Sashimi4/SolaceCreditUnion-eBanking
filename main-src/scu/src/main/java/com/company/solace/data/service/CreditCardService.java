package com.company.solace.data.service;

import com.company.solace.data.entity.CreditCard;
import com.company.solace.data.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository repository;

    public CreditCardService(){

    }

    public void saveCustomer(CreditCard creditCard){
        getRepository().save(creditCard);
    }



    public CreditCardRepository getRepository() {
        return repository;
    }
}
