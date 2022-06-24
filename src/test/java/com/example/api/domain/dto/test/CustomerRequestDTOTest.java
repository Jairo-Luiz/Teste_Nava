package com.example.api.domain.dto.test;

import com.example.api.domain.dto.CustomerRequestDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

public class CustomerRequestDTOTest {

    private CustomerRequestDTO customerDTO;

    @Before
    public void init(){
        customerDTO = new CustomerRequestDTO("test", "test@test", new ArrayList<>());
        customerDTO = new CustomerRequestDTO();
        customerDTO.setCustomerAddresses(new ArrayList<>());
        customerDTO.setEmail("test@test");
        customerDTO.setName("test");
    }

    @Test
    public void getCustomerDTONameTest(){
        assertNotNull(customerDTO.getName());
    }

    @Test
    public void getCustomerDTOEmailTest(){
        assertNotNull(customerDTO.getEmail());
    }

    @Test
    public void getCustomerDTOAddressTest(){
        assertNotNull(customerDTO.getCustomerAddresses());
    }

}
