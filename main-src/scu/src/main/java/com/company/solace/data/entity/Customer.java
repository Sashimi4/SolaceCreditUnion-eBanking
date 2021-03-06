package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Database Customer relation which gets translated into a table.
 * It contains all information for the DB entity like columns and references.
 */
@Entity
public class Customer extends AbstractEntity {

    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email = "";

    @NotEmpty
    private String phone = "";

    @NotEmpty
    private String country = "";

    @NotEmpty
    private String address = "";

    @NotEmpty
    private String password = "";

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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", mailSubscriber=" + mailSubscriber +
                '}';
    }
}
