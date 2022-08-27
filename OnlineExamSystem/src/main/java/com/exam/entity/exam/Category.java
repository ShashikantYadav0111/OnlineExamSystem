package com.exam.entity.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//to autoincrement the value
	private int cid;
	private String description;
	private String title;
	
	//eager means when you take out category all the quizzes also come out 
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "category")//all the responsible will be of category colums in quiz(table) pojo
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//when we fetch data of category we should not get quizzes (cyclic dependency) when you take out category quizset will come when quizset the quiz then quiz has category so it will have cyclic dependency so we ignore from this side 
	private Set<Quiz> quizSet = new LinkedHashSet<Quiz>(); //in order to maintain the order we use linkedHashset
	
	
	
	public Set<Quiz> getQuizSet() {
		return quizSet;
	}



	public void setQuizSet(Set<Quiz> quizSet) {
		this.quizSet = quizSet;
	}



	public Category() {
		
	}
	
	

	public Category(String description, String title) {
		this.description = description;
		this.title = title;
	}



	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	
	

}
