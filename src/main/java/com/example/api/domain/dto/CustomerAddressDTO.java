package com.example.api.domain.dto;

import javax.persistence.Column;

public class CustomerAddressDTO {

    private String houseNumber;
    private String Street;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public CustomerAddressDTO() {
    }

    public CustomerAddressDTO(String houseNumber, String street, String district, String city, String state, String country, String zipCode) {
        this.houseNumber = houseNumber;
        Street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}