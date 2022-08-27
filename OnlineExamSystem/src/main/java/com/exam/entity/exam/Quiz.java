package com.exam.entity.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autoincrement the value
	private int qid;
	private String title;
	private String description;
	private String maxMarks;
	private String numberOfQuestions;
	private boolean active = false; // by default it will be false until admit activates it
	
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//important 
	private Category category;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "quiz")//when lazy it means we have to call the getter then only the data gets loaded
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//when we fetch quiz we dont get the data of questions
	private Set<Questions> questions=new HashSet<Questions>();
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Set<Questions> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}


	public Quiz() {
		
	}


	public int getQid() {
		return qid;
	}


	public void setQid(int qid) {
		this.qid = qid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getMaxMarks() {
		return maxMarks;
	}


	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}


	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}


	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	

}
