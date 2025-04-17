package org.model;

import java.sql.Date;
import java.util.Objects;

public class Projects {
    private Integer projectID;
    private Integer CVID;
    private Date startDate;
    private Date endDate;
    private String projectName;
    private String PJRole;
    private String technology;
    private String PJDescription;

    public Integer getProjectID() {
        return projectID;
    }
    public Integer getCVID() {
        return CVID;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public String getProjectName() {
        return projectName;
    }
    public String getPJRole() {
        return PJRole;
    }
    public String getTechnology() {
        return technology;
    }
    public String getPJDescription() {
        return PJDescription;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }
    public void setCVID(Integer CVID) {
        this.CVID = CVID;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setPJRole(String PJRole) {
        this.PJRole = PJRole;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public void setPJDescription(String PJDescription) {
        this.PJDescription = PJDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projects)) return false;
        Projects projects = (Projects) o;
        return Objects.equals(projectID, projects.projectID) && Objects.equals(CVID, projects.CVID) && Objects.equals(startDate, projects.startDate) && Objects.equals(endDate, projects.endDate) && Objects.equals(projectName, projects.projectName) && Objects.equals(PJRole, projects.PJRole) && Objects.equals(technology, projects.technology) && Objects.equals(PJDescription, projects.PJDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectID, CVID, startDate, endDate, projectName, PJRole, technology, PJDescription);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Projects{");
        sb.append("projectID=").append(projectID);
        sb.append(", CVID=").append(CVID);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append(", PJRole='").append(PJRole).append('\'');
        sb.append(", technology='").append(technology).append('\'');
        sb.append(", PJDescription='").append(PJDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
