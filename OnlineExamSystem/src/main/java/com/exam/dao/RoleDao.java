package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Role;

@Repository
public interface RoleDao  extends JpaRepository<Role, Long>{

}
