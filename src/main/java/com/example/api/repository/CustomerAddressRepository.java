package com.example.api.repository;

import com.example.api.domain.CustomerAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Long> {
}