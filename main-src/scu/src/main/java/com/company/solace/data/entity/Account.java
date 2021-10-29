package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.ManyToOne;

/**
 *
 */
public class Account extends AbstractEntity {

    @ManyToOne
    private Customer customer_fk;




}
