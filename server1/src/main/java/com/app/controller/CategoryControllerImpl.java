package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.Response;
import com.app.entities.Category;
import com.app.services.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryControllerImpl {

	@Autowired
	CategoryServiceImpl categoryService;
	
	public CategoryControllerImpl() {
		System.out.println("In Category Controller");
	}
	
	@GetMapping("/all") //get all category
	public ResponseEntity<?> getAllCategory( ){
		
		return Response.success(categoryService.getAllCategory());
	}
	
	@PostMapping("/add")//add new category
	public ResponseEntity<?> addCategory(@RequestBody Category c){
		return Response.success(categoryService.addCategory(c));
		
	}
	
	@GetMapping("/{categoryId}") //get category by id
	public ResponseEntity<?> getCategoryById(@PathVariable int categoryId ){
		return Response.success(categoryService.getById(categoryId));
		
	}
	
	@PutMapping("/update/{catId}") //update category
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<?> updateProduct(@RequestBody Category c,@PathVariable int catId)
	{
		return Response.success(categoryService.updateCategory(c,catId));
	}
	
	@DeleteMapping("/delete/{catId}") //delete category
	public ResponseEntity<?> deleteProduct(@PathVariable int catId )
	{
		return ResponseEntity.ok(categoryService.deleteCategory(catId));
	}
}
