package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.Credentials;
import com.app.dtos.CustomerDTO;
import com.app.dtos.Response;
import com.app.entities.Customer;
import com.app.services.CustomerServiceImpl;

@CrossOrigin
@RestController
public class CustomerControllerImpl {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/user/signin")
	public ResponseEntity<?> signIn(@RequestBody Credentials cred)
	{
		try {
			CustomerDTO customerDTO=customerService.findCustomerByEmailAndPassword(cred);
			if(customerDTO == null)
					return Response.error("user not found");
			return Response.success(customerDTO);
		    }
		catch(Exception e)
		{
			return Response.error(e.getMessage());
		}
	}

	@PostMapping("/user/signup")
	public ResponseEntity<?> signUp(@RequestBody CustomerDTO customerDTO)
	{
			Map<String,Object> result=customerService.saveNewCustomer(customerDTO);
			if(result == null)
					return Response.error("user not inserted");
			return Response.success(result);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> emailExistsHandler(DataIntegrityViolationException ex)
	{
		return Response.error(ex.getMessage());
	}
}
