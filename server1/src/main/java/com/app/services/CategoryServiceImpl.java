package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.CategoryDao;
import com.app.entities.Category;

@Service
public class CategoryServiceImpl {

	@Autowired
	CategoryDao categoryRepo;
	
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}
	
	public Category addCategory(Category c) {
		
		return  categoryRepo.save(c);
	}
	
	public Category getById(int catId) {
		return categoryRepo.findById(catId).get();
	}
	
	public Category updateCategory(Category c,int catId) {
		c.setId(catId);
		return categoryRepo.save(c);
	}
	
	public Category deleteCategory(int catId) {

		Category c=categoryRepo.findById(catId).get();
		categoryRepo.delete(c);
		return c;
	}
}
