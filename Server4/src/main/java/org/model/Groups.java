package org.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Groups {
	private Integer groupID;
	private String groupName;
	private HashSet<Integer> currentSchedules;
	private HashMap<Integer, Boolean> groupMember;

	public Groups() {}

	public Groups(Integer groupID, String groupName) {
		this.groupID = groupID;
		this.groupName = groupName;
	}

	public Integer getGroupID() {
		return groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public HashSet<Integer> getCurrentSchedules() {
		return currentSchedules;
	}
	public HashMap<Integer, Boolean> getGroupMember() {
		return groupMember;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void setCurrentSchedules(HashSet<Integer> currentSchedules) {
		this.currentSchedules = currentSchedules;
	}
	public void setGroupMember(HashMap<Integer, Boolean> groupMember) {
		this.groupMember = groupMember;
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
		sb.append(", currentSchedules=").append(currentSchedules);
		sb.append(", groupMember=").append(groupMember);
		sb.append('}');
		return sb.toString();
	}
}
