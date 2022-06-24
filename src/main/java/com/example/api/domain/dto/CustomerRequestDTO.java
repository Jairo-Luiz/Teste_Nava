package com.example.api.domain.dto;

import java.util.List;

public class CustomerRequestDTO {

    private String name;
    private String email;
    private List<CustomerAddressRequestDTO> customerAddresses;

    public CustomerRequestDTO() {
    }

    public CustomerRequestDTO(String name, String email, List<CustomerAddressRequestDTO> customerAddresses) {
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

    public List<CustomerAddressRequestDTO> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(List<CustomerAddressRequestDTO> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }
}