package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Entity
public class Account extends AbstractEntity {

    @ManyToOne
    private Customer customer_fk;

    @ManyToOne
    private Customer acc_type_fk;

    @NotNull
    private Double balance = 0.0;


    public Customer getCustomer_fk() {
        return customer_fk;
    }
    public void setCustomer_fk(Customer customer_fk) {
        this.customer_fk = customer_fk;
    }
    public Customer getAcc_type_fk() {
        return acc_type_fk;
    }
    public void setAcc_type_fk(Customer acc_type_fk) {
        this.acc_type_fk = acc_type_fk;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
