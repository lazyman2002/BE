package org.model;

import java.util.Objects;

public class Recruiters extends Users {
	private Integer recruiterID;
	private Integer companiesID;
	private Integer roleID;
	private Integer roleName;
	private String departmentName;

	private static Integer currentID = 1;

	public Recruiters(Users users) {
		super(users.getUserID(),
				users.getUsername(),
				users.getPassword_hashed(),
				users.getFirstName(),
				users.getLastName(),
				users.getEmail(),
				users.isCandidate());
	}

	public Integer getRecruiterID() {
		return recruiterID;
	}
	public Integer getCompaniesID() {
		return companiesID;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public Integer getRoleName() {
		return roleName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public static Integer getCurrentID() {
		return currentID;
	}

	public void setRecruiterID(Integer recruiterID) {
		this.recruiterID = recruiterID;
	}
	public void setCompaniesID(Integer companiesID) {
		this.companiesID = companiesID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public void setRoleName(Integer roleName) {
		this.roleName = roleName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public static void setCurrentID(Integer currentID) {
		Recruiters.currentID = currentID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Recruiters that = (Recruiters) o;
		return recruiterID == that.recruiterID && companiesID == that.companiesID && roleID == that.roleID && roleName == that.roleName && Objects.equals(departmentName, that.departmentName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), recruiterID, companiesID, roleID, roleName, departmentName);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Recruiters{");
		sb.append("recruiterID=").append(recruiterID);
		sb.append(", companiesID=").append(companiesID);
		sb.append(", roleID=").append(roleID);
		sb.append(", roleName=").append(roleName);
		sb.append(", departmentName='").append(departmentName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
