package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService qService;
	
	//addingQuestion
	@PostMapping("/")
	public Quiz addQuiz(@RequestBody Quiz quiz){
		return this.qService.addQuiz(quiz);
	}
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz){
		return this.qService.updateQuiz(quiz);
	}
	@GetMapping("/")
	public Set<Quiz> getQuizzes(){
		return new HashSet<Quiz>(this.qService.getQuizzes());
		
	}
	@GetMapping("/{qid}")
	public Quiz getQuizById(@PathVariable("qid") Long qid){
		Quiz quiz=this.qService.getQuizById(qid);
		return quiz;
		
	}
	@DeleteMapping("/{qid}")
	public void deleteQuizById(@PathVariable("qid") Long qid) {
		this.qService.deleteQuiz(qid);
	}
	
}
