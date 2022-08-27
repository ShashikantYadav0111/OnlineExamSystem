package com.exam.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.QuizDao;
import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;

@Service
public class QuizServiceImpl implements QuizService {//making API's
	
	@Autowired
	private QuizDao q_dao; 
	
	@Override
	public Quiz addQuiz(Quiz quiz) {		
		return this.q_dao.save(quiz);//when we give new object it creates(save method)
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {		
		return this.q_dao.save(quiz);//when we pass the old id it updates that(save method)
	}

	@Override
	public Set<Quiz> getQuizzes() {		
		return new HashSet<Quiz>(this.q_dao.findAll());
	}

	@Override
	public Quiz getQuizById(int qid) {	
		return this.q_dao.findById(qid).get();
	}

	@Override
	public void deleteQuiz(int qid){
		this.q_dao.deleteById(qid);
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		return this.q_dao.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		 return this.q_dao.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		 return this.q_dao.findByCategoryAndActive(c, true);
	}

}
