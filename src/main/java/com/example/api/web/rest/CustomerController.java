package com.example.api.web.rest;

import java.util.List;

import com.example.api.assembler.CustomerAssembly;
import com.example.api.domain.dto.CustomerRequestDTO;
import com.example.api.domain.dto.ResponseListDTO;
import com.example.api.domain.dto.CustomerResponseDTO;
import com.example.api.domain.dto.ResponseDTO;
import com.example.api.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;
	private CustomerAssembly<CustomerResponseDTO> customerAssembly;
	private MapperUtil mapperUtil;

	@Autowired
	public CustomerController(CustomerService service, CustomerAssembly<CustomerResponseDTO> customerAssembly, MapperUtil mapperUtil) {
		this.service = service;
		this.customerAssembly = customerAssembly;
		this.mapperUtil = mapperUtil;
	}

	@GetMapping
	public ResponseListDTO<List<CustomerResponseDTO>> findAll(@RequestParam int page, @RequestParam int size) {
		return customerAssembly.toCollectionModel(service.findAll(page, size));
	}

	@GetMapping("/{id}")
	public ResponseDTO<CustomerResponseDTO> findById(@PathVariable Long id) {
		return customerAssembly.toResponseModel(mapperUtil.convertTo(service.findById(id).get(), CustomerResponseDTO.class));
	}

	@PostMapping
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerRequestDTO customerDTO) {
		try {
			return ResponseEntity.ok(customerAssembly.toResponseModel(mapperUtil.convertTo(service.createCustomer(customerDTO), CustomerResponseDTO.class)));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<Object> findById(@RequestBody CustomerResponseDTO customerDTO) {
		try {
			return ResponseEntity.ok(customerAssembly.toResponseModel(mapperUtil.convertTo(service.updateCustomer(customerDTO), CustomerResponseDTO.class)));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try{
			return ResponseEntity.ok(service.deleteById(id));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not deleted!");
		}
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<String> deleteAddressById(@PathVariable Long id) {
		try{
			return ResponseEntity.ok(service.deleteAddressById(id));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not deleted!");
		}
	}
}