package com.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.app.daos.ProductDao;
import com.app.entities.Product;

@SpringBootTest
class ProductDaoTest {

	@Autowired
	private ProductDao productDao;
	
	
	@Test
	void testFindAll() {
		List<Product> list=productDao.findAll();
		list.forEach(System.out::println);
		
	}
	
}
