package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class CreditCard extends AbstractEntity {

    @NotNull
    @ManyToOne
    private Account account;

    @NotNull
    private Date expirationDate;

    @NotEmpty
    private String phone = "";
    private boolean mailSubscriber;

}
