package com.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.app.daos.CustomerDao;
import com.app.entities.Customer;

@SpringBootTest
class CustomerDaoTests {

	@Autowired
	private CustomerDao customerDao;
	
	@Test
	void testFindAll() {
		List<Customer> list=customerDao.findAll();
		list.forEach(System.out::println);
		
	}

}
