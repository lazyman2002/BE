package org.model;

import java.util.Objects;

public class Recruiters extends Users {
	private Integer companyID;
	private Integer roleID;
	private String roleName;
	private String departmentName;

	public Recruiters() {
	}
	public Recruiters(Users users) {
		super(users.getUserID(),
				users.getUsername(),
				users.getPassword_hashed(),
				users.getFirstName(),
				users.getLastName(),
				users.getEmail(),
				users.isCandidate());
	}

	public Integer getCompanyID() {
		return companyID;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getDepartmentName() {
		return departmentName;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
