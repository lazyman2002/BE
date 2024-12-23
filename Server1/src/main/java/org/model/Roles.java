package org.model;

import java.util.Objects;

public class Roles {
	private Integer roleID;
	private String roleName;
	private Integer companyID;
	private Integer roleLevel;

	public Roles(Integer roleID, String roleName, Integer companyID, Integer roleLevel) {
		this.roleID = roleID;
		this.roleName = roleName;
		this.companyID = companyID;
		this.roleLevel = roleLevel;
	}

	public Roles(){}
	public Roles(int recruiterID, int level) {
		this.companyID = recruiterID;
		this.roleLevel = level;
	}

	public Integer getRoleID() {
		return roleID;
	}
	public Integer getCompanyID() {
		return companyID;
	}
	public Integer getRoleLevel() {
		return roleLevel;
	}
	public String getRoleName() {
		return roleName;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Roles)) return false;
		Roles roles = (Roles) o;
		return Objects.equals(roleID, roles.roleID) && Objects.equals(roleName, roles.roleName) && Objects.equals(companyID, roles.companyID) && Objects.equals(roleLevel, roles.roleLevel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleID, roleName, companyID, roleLevel);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Roles{");
		sb.append("roleLevel=").append(roleLevel);
		sb.append(", companyID=").append(companyID);
		sb.append(", roleName='").append(roleName).append('\'');
		sb.append(", roleID=").append(roleID);
		sb.append('}');
		return sb.toString();
	}
}
