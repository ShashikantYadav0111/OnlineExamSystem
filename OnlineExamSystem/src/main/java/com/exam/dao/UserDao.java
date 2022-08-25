package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	public User findByusername(String username);
	

	

}
