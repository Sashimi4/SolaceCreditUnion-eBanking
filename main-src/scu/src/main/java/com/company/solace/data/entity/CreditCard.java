package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class CreditCard extends AbstractEntity {

    @NotNull
    @ManyToOne
    private Account account;

    @NotNull
    @Column(unique = true)
    private String cardNumber;

    @NotNull
    private String csc;

    @NotNull
    private Date expirationDate;


    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCsc() {
        return csc;
    }
    public void setCsc(String csc){
        this.csc = csc;
    }
}
