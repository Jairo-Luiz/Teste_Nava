package com.example.api.domain.dto;

import java.util.List;

public class CustomerResponseDTO {

    private String name;
    private String email;
    private List<CustomerAddressResponseDTO> customerAddresses;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(String name, String email, List<CustomerAddressResponseDTO> customerAddresses) {
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

    public List<CustomerAddressResponseDTO> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(List<CustomerAddressResponseDTO> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", customerAddresses=" + customerAddresses +
                '}';
    }
}