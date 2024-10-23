package org.app;

import java.util.Objects;

public class Recruiters extends Users {
	private int recruiterID;
	private int companiesID;
	private int roleID;
	private int roleName;
	private String departmentName;

	private static int currentID = 1;

	public Recruiters(String username,
					  String password_hashed,
					  String firstName,
					  String lastName,
					  String email,
					  int companiesID,
					  int roleID,
					  int roleName,
					  String departmentName) {
		super(username, password_hashed, firstName, lastName, email);
		this.companiesID = companiesID;
		this.roleID = roleID;
		this.roleName = roleName;
		this.departmentName = departmentName;
		this.recruiterID = currentID;
		currentID+=1;
	}

	public int getRecruiterID() {
		return recruiterID;
	}
	public int getCompaniesID() {
		return companiesID;
	}
	public int getRoleID() {
		return roleID;
	}
	public int getRoleName() {
		return roleName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public static int getCurrentID() {
		return currentID;
	}

	public void setRecruiterID(int recruiterID) {
		this.recruiterID = recruiterID;
	}
	public void setCompaniesID(int companiesID) {
		this.companiesID = companiesID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public static void setCurrentID(int currentID) {
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
