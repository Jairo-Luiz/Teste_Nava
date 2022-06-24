package com.example.api.domain.test;

import com.example.api.domain.Customer;
import org.junit.Before;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.HashSet;

public class CustomerTest {

    private Customer customer;

    @Before
    public void init(){
        customer = new Customer(1l, "test", "test@test", new HashSet<>());
        customer = new Customer();
        customer.setCustomerAddresses(new HashSet<>());
        customer.setName("test");
        customer.setEmail("test@test");
        customer.setId(1l);
    }

    @Test
    public void getCustommerAddressTest(){
        assertNotNull(customer.getCustomerAddresses());
    }

    @Test
    public void getCustommerNameTest(){
        assertNotNull(customer.getName());
    }

    @Test
    public void getCustommerEmailTest(){
        assertNotNull(customer.getEmail());
    }

    @Test
    public void getCustommerIdTest(){
        assertNotNull(customer.getId());
    }

}
