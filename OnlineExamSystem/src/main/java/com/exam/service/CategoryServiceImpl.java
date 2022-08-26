package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.CategoryDao;
import com.exam.entity.exam.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao c_dao;

	@Override
	public Category addCategory(Category category) {
		return this.c_dao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.c_dao.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<Category>(this.c_dao.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		return this.c_dao.findById(categoryId).get(); //this returns optional so we do get to get category object as we need to return category
	}

	@Override
	public void deleteCategory(Long categoryId) {		
		this.c_dao.deleteById(categoryId);

	}

}
