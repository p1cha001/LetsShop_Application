package com.app.controller;

import java.util.List;

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
import com.app.entities.Product;
import com.app.services.IProduct;
import com.app.services.ProductServiceImpl;

@CrossOrigin
@RequestMapping("/product")
@RestController
public class ProductControllerImpl {

	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	private IProduct prod;
	
	@GetMapping("/all")
	public ResponseEntity<?> product()
	{
			List<Product> list=productService.findAllProducts();
			if(list == null)
					return Response.error("products not found");
			return Response.success(list);
		 
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		return ResponseEntity.ok(productService.findById(id));
	}
	
	@GetMapping("/getBy/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		return ResponseEntity.ok(productService.findByName(name));
	}
	

	@PostMapping("/add")//add product
	public ResponseEntity<?> addProduct(@RequestBody Product p)
	{
		return ResponseEntity.ok(productService.addProduct(p));
	}
	
	@PutMapping("/update/{productId}") //update product
	public ResponseEntity<?> updateProduct(@RequestBody Product p,@PathVariable int productId)
	{
		return ResponseEntity.ok(productService.updateProduct(p,productId));
	}
	@DeleteMapping("/delete/{productId}")// delete product
	public ResponseEntity<?> deleteProduct(@PathVariable int productId )
	{
		return ResponseEntity.ok(productService.deleteProduct(productId));
	}
	
	@GetMapping("/category/{cat}")
	public ResponseEntity<?> findByCat(@PathVariable int cat){
		return ResponseEntity.ok(prod.findByCat(cat));
	}
	
	@GetMapping("/low/{cat}")//sort products low to high
	public ResponseEntity<?> lowToHigh(@PathVariable int cat){
		return Response.success(prod.lowToHigh(cat));
	}
	
	@GetMapping("/high/{cat}")//sort products low to high
	public ResponseEntity<?> highToLow(@PathVariable int cat){
		return Response.success(prod.highToLow(cat));
	}
	

	@GetMapping("/freshHome")//home page data
	public ResponseEntity<?> freshHome(){
		return ResponseEntity.ok(prod.freshHome());
	}
	
	@GetMapping("/freshpage")//fresh page data
	public ResponseEntity<?> freshpage(){
		return ResponseEntity.ok(prod.freshPage());
	}
}
