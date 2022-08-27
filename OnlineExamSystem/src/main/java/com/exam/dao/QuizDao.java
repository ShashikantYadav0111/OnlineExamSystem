package com.exam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
	public List<Quiz> findBycategory(Category category);
	public List<Quiz> findByActive(Boolean b);
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);

}
