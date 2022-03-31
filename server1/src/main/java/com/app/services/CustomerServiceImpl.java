package com.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.daos.CustomerDao;
import com.app.dtos.Credentials;
import com.app.dtos.CustomerDTO;
import com.app.dtos.DtoEntityConverter;
import com.app.entities.Customer;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DtoEntityConverter converter;
	
	public List<Customer> findAllCustomer()
	{
		return customerDao.findAll();
	}
	public Customer findCustomerById(int id)
	{
		return customerDao.findById(id);
	}
	
	public Customer findCustomerByEmail(String email)
	{
		return customerDao.findByEmail(email);
		
	}
	
	public CustomerDTO findCustomerByEmailAndPassword(Credentials cred)
	{
		Customer dbCustomer = findCustomerByEmail(cred.getEmail());
		String rawPassword=cred.getPassword();
		if(dbCustomer != null && passwordEncoder.matches(rawPassword, dbCustomer.getPassword())){
			
				return converter.toCustomerDTO(dbCustomer);
		}
		
		return null;
	}
	public Map<String,Object> saveNewCustomer(CustomerDTO customerDto)
	{
		String rawPassword=customerDto.getPassword();
		String encPassword=passwordEncoder.encode(rawPassword);
		customerDto.setPassword(encPassword);
		Customer customer=converter.toCustomerEntity(customerDto);
		customerDao.save(customer);
		
		return Collections.singletonMap("inserted Id",customer.getId());
	}
	
	
	public void deleteCustomer(int id)
	{
		customerDao.deleteById(id);
	}
}
