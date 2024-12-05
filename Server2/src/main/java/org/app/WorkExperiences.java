package org.app;

import java.sql.Date;
import java.util.Objects;

public class WorkExperiences {
	private Integer CVID;
	private String jobTitle;
	private Date startDate;
	private Date endDate;
	private String jobDescription;

	public Integer getCVID() {
		return CVID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getJobDescription() {
		return jobDescription;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof WorkExperiences that)) return false;
        return Objects.equals(CVID, that.CVID) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(jobDescription, that.jobDescription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, jobTitle, startDate, endDate, jobDescription);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("WorkExperiences{");
		sb.append("CVID=").append(CVID);
		sb.append(", jobTitle='").append(jobTitle).append('\'');
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", jobDescription='").append(jobDescription).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
