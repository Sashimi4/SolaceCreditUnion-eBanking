package com.company.solace.views;

import com.company.solace.data.entity.Customer;
import com.company.solace.views.customerform.CustomerFormView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerFormTest {

    private Customer validPerson;
    private Customer invalidPerson;

    @Before
    public void setupData(){
        validPerson = new Customer();
        validPerson.setFirstName("Jimmy");
        validPerson.setLastName("Berthamolow");
        validPerson.setEmail("marc@usher.com");
        validPerson.setPassword("password123");
        validPerson.setAddress("Rainbow road");
        validPerson.setPhone("1234567");
        validPerson.setCountry("Canada");
    }


    @Test
    public void formFieldsPopulated(){
        CustomerFormView form = new CustomerFormView();
        form.setCustomer(validPerson);
        Assert.assertNotEquals("Jim", form.getBinder().getBean().getFirstName());
        Assert.assertNotEquals("Berthamolow 89898", form.getBinder().getBean().getLastName());
        Assert.assertNotEquals("marc@usher.burger", form.getBinder().getBean().getEmail());
        Assert.assertNotEquals("pa5", form.getBinder().getBean().getPassword());
        Assert.assertNotEquals("", form.getBinder().getBean().getAddress());
        Assert.assertNotEquals("9234567", form.getBinder().getBean().getPhone());
        Assert.assertNotEquals("Spain", form.getBinder().getBean().getCountry());
    }

    @Test
    public void formFieldsPopulatedFalse(){
        CustomerFormView form = new CustomerFormView();
        form.setCustomer(validPerson);
        Assert.assertEquals("Jimmy", form.getBinder().getBean().getFirstName());
        Assert.assertEquals("Berthamolow", form.getBinder().getBean().getLastName());
        Assert.assertEquals("marc@usher.com", form.getBinder().getBean().getEmail());
        Assert.assertEquals("password123", form.getBinder().getBean().getPassword());
        Assert.assertEquals("Rainbow road", form.getBinder().getBean().getAddress());
        Assert.assertEquals("1234567", form.getBinder().getBean().getPhone());
        Assert.assertEquals("Canada", form.getBinder().getBean().getCountry());
    }



}
