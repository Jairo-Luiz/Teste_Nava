package com.example.api.domain.dto;

import java.util.List;

public class CustomerDTO {

    private String name;
    private String email;
    private List<CustomerAddressDTO> customerAddresses;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String email, List<CustomerAddressDTO> customerAddresses) {
        this.name = name;
        this.email = email;
        this.customerAddresses = customerAddresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CustomerAddressDTO> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(List<CustomerAddressDTO> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }
}