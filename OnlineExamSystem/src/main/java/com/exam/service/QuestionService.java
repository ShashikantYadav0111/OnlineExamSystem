package com.exam.service;

import java.util.Set;

import com.exam.entity.exam.Questions;
import com.exam.entity.exam.Quiz;

public interface QuestionService {
	
	public Questions addQuestion(Questions question);	
	public Questions updateQuestion(Questions question);
	public Set<Questions> getQuestions();
	public Questions getQuestionById(int qid);
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz);
	public void deleteQuestion(int quid);
	public Questions get(int questionsId);
	
	
	

}
