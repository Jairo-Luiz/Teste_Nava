package com.example.api.service;

import com.example.api.domain.Customer;
import com.example.api.domain.CustomerAddress;
import com.example.api.domain.dto.CustomerAddressRequestDTO;
import com.example.api.domain.dto.CustomerRequestDTO;
import com.example.api.repository.CustomerAddressRepository;
import com.example.api.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class AddressService {

    private MapperUtil mapperUtil;
    private CustomerAddressRepository addressRepository;

    @Autowired
    public AddressService(MapperUtil mapperUtil, CustomerAddressRepository addressRepository) {
        this.mapperUtil = mapperUtil;
        this.addressRepository = addressRepository;
    }

    public Set<CustomerAddress> saveAddress(CustomerRequestDTO customerDTO, Customer customer){
        Set<CustomerAddress> addressList = new HashSet<>();
        for (CustomerAddressRequestDTO addressDTO: customerDTO.getCustomerAddresses()) {
            CustomerAddress address = mapperUtil.convertTo(addressDTO, CustomerAddress.class);
            address.setCustomerId(customer);
            address.setCreateDate(LocalDateTime.now());
            address.setUpdateDate(LocalDateTime.now());
            if (addressList.size() == 0) {
                addressList.add(addressRepository.save(address));
            } else {
                validateAddress(addressList, address);
            }
        }
        return addressList;
    }

    private void validateAddress(Set<CustomerAddress> addressList, CustomerAddress address) {
        for (CustomerAddress addressMap :addressList ){
            if (addressMap.getAddressType().equals(address.getAddressType())) {
                if (!address.getHouseNumber().equals(addressMap.getHouseNumber()) ||
                        !address.getZipCode().equals(addressMap.getZipCode())) {
                    addressList.add(addressRepository.save(address));
                }
            }else{
                addressList.add(addressRepository.save(address));
            }
        }
    }
}