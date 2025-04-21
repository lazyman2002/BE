package org.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class GroupMembers {
    private Integer userID;
    private Integer groupID;
    private Integer isAdmin;
    private Time interview;
    private Date schedule;

    public Integer getUserID() {
        return userID;
    }
    public Integer getGroupID() {
        return groupID;
    }
    public Integer getIsAdmin() {
        return isAdmin;
    }
    public Time getInterview() {
        return interview;
    }
    public Date getSchedule() {
        return schedule;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
    public void setInterview(Time interview) {
        this.interview = interview;
    }
    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupMembers)) return false;
        GroupMembers that = (GroupMembers) o;
        return Objects.equals(userID, that.userID) && Objects.equals(groupID, that.groupID) && Objects.equals(isAdmin, that.isAdmin) && Objects.equals(interview, that.interview) && Objects.equals(schedule, that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, groupID, isAdmin, interview, schedule);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GroupMembers{");
        sb.append("userID=").append(userID);
        sb.append(", groupID=").append(groupID);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", interview=").append(interview);
        sb.append(", schedule=").append(schedule);
        sb.append('}');
        return sb.toString();
    }
}
