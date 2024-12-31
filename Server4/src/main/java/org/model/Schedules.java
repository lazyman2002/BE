package org.model;

import java.sql.Timestamp;
import java.util.HashMap;

public class Schedules {
	private Integer scheduleID;
	private Timestamp timeSet;
	private Boolean isRecored;
	private Integer groupID;

//	Ngoài CSDL
	private HashMap<Integer, Integer> interviewers;
	public Schedules() {
	}

	public Integer getScheduleID() {
		return scheduleID;
	}
	public Timestamp getTimeSet() {
		return timeSet;
	}
	public Boolean getRecored() {
		return isRecored;
	}
	public Integer getGroupID() {
		return groupID;
	}
	public HashMap<Integer, Integer> getInterviewers() {
		return interviewers;
	}

	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}
	public void setTimeSet(Timestamp timeSet) {
		this.timeSet = timeSet;
	}
	public void setRecored(Boolean recored) {
		isRecored = recored;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public void setInterviewers(HashMap<Integer, Integer> interviewers) {
		this.interviewers = interviewers;
	}
}
