package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private Long roleId;
	private String roleName;
	
	//when we take out role then instantly userrole should not come when we call then only its should come
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy ="role")
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<UserRole>();

	public Role(Long roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Role() {

	}

	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
