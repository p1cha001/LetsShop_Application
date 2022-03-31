package com.app.dtos;

import org.springframework.stereotype.Component;

import com.app.entities.Customer;

@Component
public class DtoEntityConverter {

	public CustomerDTO toCustomerDTO(Customer entity)
	{
		CustomerDTO dto=new CustomerDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setRole(entity.getRole());
		return dto;
		
	}
	public Customer toCustomerEntity(CustomerDTO customerDto)
	{
		Customer customer=new Customer();
		customer.setId(customerDto.getId());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPassword(customerDto.getPassword());
		customer.setEmail(customerDto.getEmail());
		
		return customer;
	}
}
