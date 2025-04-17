package org.model;

import java.util.Objects;

public class Recruiters extends Users {
	private Integer branchID;
	private Integer roleLevel;
	private String roleName;
	private String departmentName;

	public Recruiters() {}

	public Recruiters(Users users){
		this.setUserID(users.getUserID());
		this.setUsername(users.getUsername());
		this.setPassword_hashed(users.getPassword_hashed());
		this.setFirstName(users.getFirstName());
		this.setLastName(users.getLastName());
		this.setEmail(users.getEmail());
		this.setCandidate(users.isCandidate());
	}

	public Integer getBranchID() {
		return branchID;
	}
	public Integer getRoleLevel() {
		return roleLevel;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getDepartmentName() {
		return departmentName;
	}

	public void setBranchID(Integer branchID) {
		this.branchID = branchID;
	}
	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Recruiters)) return false;
		if (!super.equals(o)) return false;
		Recruiters that = (Recruiters) o;
		return Objects.equals(branchID, that.branchID) && Objects.equals(roleLevel, that.roleLevel) && Objects.equals(roleName, that.roleName) && Objects.equals(departmentName, that.departmentName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), branchID, roleLevel, roleName, departmentName);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Recruiters{");
		sb.append("branchID=").append(branchID);
		sb.append(", roleLevel=").append(roleLevel);
		sb.append(", roleName='").append(roleName).append('\'');
		sb.append(", departmentName='").append(departmentName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
