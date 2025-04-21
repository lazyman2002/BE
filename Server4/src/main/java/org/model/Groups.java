package org.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Groups {
	private Integer groupID;
	private String groupName;

	public Groups(Integer groupID, String groupName) {
		this.groupID = groupID;
		this.groupName = groupName;
	}

	public Groups() {}

	public Integer getGroupID() {
		return groupID;
	}
	public String getGroupName() {
		return groupName;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Groups)) return false;
		Groups groups = (Groups) o;
		return Objects.equals(groupID, groups.groupID) && Objects.equals(groupName, groups.groupName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupID, groupName);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Groups{");
		sb.append("groupID=").append(groupID);
		sb.append(", groupName='").append(groupName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
