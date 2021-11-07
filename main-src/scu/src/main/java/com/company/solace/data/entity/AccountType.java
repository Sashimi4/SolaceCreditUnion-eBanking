package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

/**
 * Database Account type relation which gets translated into a table.
 * It contains all information for the DB entity like columns and references.
 */
@Entity
public class AccountType extends AbstractEntity {

    @NotEmpty
    private String acc_type = "";


    public String getAcc_type() {
        return acc_type;
    }
    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }
}
