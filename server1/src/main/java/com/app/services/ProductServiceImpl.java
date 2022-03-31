package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.ProductDao;
import com.app.entities.Product;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductDao productDao;
	public List<Product> findAllProducts()
	{
		return productDao.findAll();
	}
	
	public Product findById(int id)
	{
		return productDao.getById(id);
	}
	
	public List<Product> findByName(String name)
	{
		return productDao.findByName(name);
	}
	

	public Product addProduct(Product p) {
		
		return productDao.save(p);
	}


	public Product deleteProduct(int productId) {
		
		Product p=productDao.findById(productId).get();
		//prodRepo.delete(p);
		
		productDao.deleteById(productId);
		
		return p;
	}


	public Product updateProduct(Product product,int productId) {
		// TODO Auto-generated method stub
		//Product prod=prodRepo.findById(productId).get();
		product.setId(productId);
		return productDao.save(product);
	}
}
