package com.company.solace.data.entity;

import com.company.solace.data.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Company extends AbstractEntity {

    @OneToMany(mappedBy = "company")
    private List<Contact> employees = new LinkedList<>();

    public List<Contact> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Contact> employees) {
        this.employees = employees;
    }
}
