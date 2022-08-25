package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserAlreadyPresent;

public interface UserService {
	
	public User createUser(User user,Set<UserRole> userRoles) throws UserAlreadyPresent;//created user can be anything staff,admin,student so a set 
	//in the front end one user has only one role to generalize it later we make a set.
	//get user by username
	public User getUser(String username);
	//delete user by id
	public void deleteUser(Long userId);
	

}
