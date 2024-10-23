package org.app;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Groups {
	private int groupID;
	private ConcurrentHashMap<Integer, Boolean> admin;
	private String groupName;
	private ConcurrentHashMap<Schedules, Boolean> currentSchedules;

	private static int currentID;

	public Groups(String groupName, int admin) {
		this.groupName = groupName;
		this.groupID = currentID;
		currentID+=1;
		this.admin = new ConcurrentHashMap<>();
		this.admin.put(admin, true);
		this.currentSchedules = new ConcurrentHashMap<>();
	}

	public int getGroupID() {
		return groupID;
	}
	public ConcurrentHashMap<Integer, Boolean> getAdmin() {
		return admin;
	}
	public String getGroupName() {
		return groupName;
	}
	public ConcurrentHashMap<Schedules, Boolean> getCurrentSchedules() {
		return currentSchedules;
	}

	public void setAdmin(ConcurrentHashMap<Integer, Boolean> admin) {
		this.admin = admin;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void setCurrentSchedules(ConcurrentHashMap<Schedules, Boolean> currentSchedules) {
		this.currentSchedules = currentSchedules;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Groups groups = (Groups) o;
		return groupID == groups.groupID && Objects.equals(admin, groups.admin) && Objects.equals(groupName, groups.groupName) && Objects.equals(currentSchedules, groups.currentSchedules);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupID, admin, groupName, currentSchedules);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Groups{");
		sb.append("groupID=").append(groupID);
		sb.append(", admin=").append(admin);
		sb.append(", groupName='").append(groupName).append('\'');
		sb.append(", currentSchedules=").append(currentSchedules);
		sb.append('}');
		return sb.toString();
	}
}
