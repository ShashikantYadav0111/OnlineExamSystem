package com.exam.controller;

import java.util.Set;

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

import com.exam.entity.exam.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")//allowing all hosts
public class CategoryController {
	
	@Autowired
	private CategoryService cSercive;
	
	//addCategory
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){// using request body because the data comes in json format
		Category category1=this.cSercive.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	//getCategoryById
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long cid) {
		Category category1=this.cSercive.getCategory(cid);
		return category1;
	}
	//getAllCategories
	@GetMapping("/")
	public ResponseEntity<Set<Category>> getAllCategory(){
		return ResponseEntity.ok(this.cSercive.getCategories());
	}
	
	//updateCategory
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category){
		return this.cSercive.updateCategory(category);
		
	}
	
	//deleteCategory
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long cid) {
		this.cSercive.deleteCategory(cid);
	}

}
