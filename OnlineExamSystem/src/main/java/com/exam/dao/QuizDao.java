package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.exam.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Long> {

}
