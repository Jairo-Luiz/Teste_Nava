package com.example.api.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String addressType;
    @Column
    private String houseNumber;
    @Column
    private String street;
    @Column
    private String district;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String zipCode;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable=false)
    private Customer customerId;

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }


    public CustomerAddress() {
    }

    public CustomerAddress(Long id, String addressType, String houseNumber, String street, String district, String city, String state, String country, String zipCode, LocalDateTime createDate, LocalDateTime updateDate, Customer customerId) {
        this.id = id;
        this.addressType = addressType;
        this.houseNumber = houseNumber;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.customerId = customerId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}