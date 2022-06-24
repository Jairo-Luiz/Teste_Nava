package com.example.api.service;

import com.example.api.domain.Customer;
import com.example.api.domain.CustomerAddress;
import com.example.api.domain.dto.CustomerRequestDTO;
import com.example.api.domain.dto.CustomerResponseDTO;
import com.example.api.repository.CustomerAddressRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {

	private CustomerRepository repository;
	private CustomerAddressRepository addressRepository;
	private MapperUtil mapperUtil;
	private AddressService addressService;

	@Autowired
	public CustomerService(CustomerRepository repository, CustomerAddressRepository addressRepository, MapperUtil mapperUtil, AddressService addressService) {
		this.repository = repository;
		this.addressRepository = addressRepository;
		this.mapperUtil = mapperUtil;
		this.addressService = addressService;
	}

	public Page<Customer> findAll(int page, int size) {
		return repository.findAll(PageRequest.of(page <= 0 ? 0 : (page - 1), size));
	}

	public Optional<Customer> findById(Long id) {
		return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")));
	}

	public String deleteById(Long id) {
		Optional<Customer> customer = repository.findById(id);
		if(customer.isPresent()){
			customer.get().getCustomerAddresses().stream().forEach(address -> {
				addressRepository.deleteById(address.getId());
			});
			repository.deleteById(id);
		}
		return "Customer Deleted!";
	}

	public Customer createCustomer(CustomerRequestDTO customerDTO) {
		try{
			Customer customer = new Customer();
			customer.setEmail(customerDTO.getEmail());
			customer.setName(customerDTO.getName());
			customer = repository.save(customer);
			try{
				customer.setCustomerAddresses(addressService.saveAddress(customerDTO, customer));
			}catch (Exception e){
				throw new RuntimeException("Error save Address: " + customerDTO.getCustomerAddresses().toString());
			}
			return customer;
		}catch (Exception e){
			throw new RuntimeException(e.getMessage().contains("Error save Address:")? e.getMessage() : "Error create Customer: " + customerDTO.getEmail());
		}

	}

	public Customer updateCustomer(CustomerResponseDTO customerDTO) {
		Customer customerOld = new Customer();
		try {
			customerOld = repository.findByEmail(customerDTO.getEmail());

		Customer customerNew = mapperUtil.convertTo(customerDTO, Customer.class);
		Set<CustomerAddress> addressList = new HashSet<>();

		for (CustomerAddress address: customerNew.getCustomerAddresses()) {
			address.setCustomerId(customerOld);
			address.setUpdateDate(LocalDateTime.now());
			address.setCreateDate(LocalDateTime.now());
			addressList.add(addressRepository.save(address));
		}
		customerNew.setCustomerAddresses(addressList);
		customerNew.setId(customerOld.getId());
		return repository.save(customerNew);
		}catch (Exception e){
			throw new RuntimeException("Email não encontrado!");
		}
	}

	public String deleteAddressById(Long id) {
		Optional<CustomerAddress> address = addressRepository.findById(id);
		if(address.isPresent()){
				addressRepository.deleteById(address.get().getId());
			}
		return "Address Deleted!";
	}
}