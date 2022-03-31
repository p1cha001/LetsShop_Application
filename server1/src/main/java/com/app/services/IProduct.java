package com.app.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Product;

public interface IProduct extends JpaRepository<Product,Integer>{

	@Query(nativeQuery = true,value = 
	"select * from product where category_id=:cat")	
	ArrayList<Product> findByCat(@Param("cat") int cat);
	
	@Query(nativeQuery = true,value =
	"select * from product where category_id=:cat order by price")
	ArrayList<Product> lowToHigh(@Param("cat") int cat);
	
	@Query(nativeQuery = true,value = 
	"select * from product where category_id=:cat order by price desc ")	
	ArrayList<Product> highToLow(@Param("cat") int cat);
	

	@Query(nativeQuery = true,value="select * from product limit 6")
	ArrayList<Product> freshHome();

	@Query(nativeQuery = true,value="select * from product limit 15")
	ArrayList<Product> freshPage();
}
