package com.exam.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.QuizDao;
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
	public Quiz getQuizById(Long qid) {	
		return this.q_dao.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid){
		this.q_dao.deleteById(qid);
	}

}
