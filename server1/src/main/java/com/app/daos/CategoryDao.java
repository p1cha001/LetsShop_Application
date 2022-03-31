package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;

public interface CategoryDao extends JpaRepository<Category,Integer> {

}
