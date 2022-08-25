package com.exam.entity.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autoincrement the value
	private Long qid;
	private String title;
	private String description;
	private String maxMarks;
	private String numberOfQuestions;
	private boolean active = false; // by default it will be false until admit activates it
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "quiz")//when lazy it means we have to call the getter then only the data gets loaded
	@JsonIgnore//when we fetch quiz we dont get the data of questions
	private Set<Questions> questions=new HashSet<Questions>();
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Quiz() {
		
	}


	public Long getQid() {
		return qid;
	}


	public void setQid(Long qid) {
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
