package org.app;

import java.sql.Timestamp;
import java.util.Objects;

public class Schedules {
	private int scheduleID;
	private Timestamp timeSet;
	private boolean isRecored;

	private static int currentID = 1;

	public Schedules(Timestamp timeSet, boolean isRecored) {
		this.timeSet = timeSet;
		this.isRecored = isRecored;
		this.scheduleID = currentID;
		currentID+=1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Schedules schedules = (Schedules) o;
		return scheduleID == schedules.scheduleID && isRecored == schedules.isRecored && Objects.equals(timeSet, schedules.timeSet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(scheduleID, timeSet, isRecored);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Schedules{");
		sb.append("scheduleID=").append(scheduleID);
		sb.append(", timeSet=").append(timeSet);
		sb.append(", isRecored=").append(isRecored);
		sb.append('}');
		return sb.toString();
	}
}
