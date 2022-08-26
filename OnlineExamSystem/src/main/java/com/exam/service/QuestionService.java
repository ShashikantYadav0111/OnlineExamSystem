package com.exam.service;

import java.util.Set;

import com.exam.entity.exam.Questions;
import com.exam.entity.exam.Quiz;

public interface QuestionService {
	
	public Questions addQuestion(Questions question);
	public Questions updateQuestion(Questions question);
	public Set<Questions> getQuestions();
	public Questions getQuestion(Long qid);
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz);
	
	
	

}
