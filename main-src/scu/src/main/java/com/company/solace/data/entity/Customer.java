package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 */
@Entity
public class Customer extends AbstractEntity {

    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";

    @NotEmpty
    @Email
    private String email = "";

    @NotEmpty
    private String phone = "";

    @NotEmpty
    private String country = "";

    @NotEmpty
    private String address = "";

    private boolean mailSubscriber;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isMailSubscriber() {
        return mailSubscriber;
    }
    public void setMailSubscriber(boolean mailSubscriber) {
        this.mailSubscriber = mailSubscriber;
    }
}
