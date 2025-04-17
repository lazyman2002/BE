package org.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class JobRequests {
	private Integer jobID;
	private Integer branchID;

	private String title;
	private String worktime;
	private String jobField;
	private Integer locationID;
	private JobType jobType;
	private Integer salaryLeast;
	private Integer salaryGreatest;
	private Date deadlineDate;

	private String jobTitle;
	private JobLevel jobLevel;
	private String jobDescription;
	private String jobRequirement;
	private String jobBenefit;

	private Integer groupID;
	private Timestamp createdAt;
	private Timestamp updatedAt;

//	Không có trong CSDL
	private HashSet<Integer> currentCVs;

	public JobRequests() {
	}

	public Integer getJobID() {
		return jobID;
	}
	public Integer getBranchID() {
		return branchID;
	}
	public String getTitle() {
		return title;
	}
	public String getWorktime() {
		return worktime;
	}
	public String getJobField() {
		return jobField;
	}
	public Integer getLocationID() {
		return locationID;
	}
	public JobType getJobType() {
		return jobType;
	}
	public Integer getSalaryLeast() {
		return salaryLeast;
	}
	public Integer getSalaryGreatest() {
		return salaryGreatest;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public JobLevel getJobLevel() {
		return jobLevel;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public String getJobRequirement() {
		return jobRequirement;
	}
	public String getJobBenefit() {
		return jobBenefit;
	}
	public Integer getGroupID() {
		return groupID;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public HashSet<Integer> getCurrentCVs() {
		return currentCVs;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}
	public void setBranchID(Integer branchID) {
		this.branchID = branchID;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public void setJobField(String jobField) {
		this.jobField = jobField;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public void setSalaryLeast(Integer salaryLeast) {
		this.salaryLeast = salaryLeast;
	}
	public void setSalaryGreatest(Integer salaryGreatest) {
		this.salaryGreatest = salaryGreatest;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setJobLevel(JobLevel jobLevel) {
		this.jobLevel = jobLevel;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}
	public void setJobBenefit(String jobBenefit) {
		this.jobBenefit = jobBenefit;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setCurrentCVs(HashSet<Integer> currentCVs) {
		this.currentCVs = currentCVs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof JobRequests)) return false;
		JobRequests that = (JobRequests) o;
		return Objects.equals(jobID, that.jobID) && Objects.equals(branchID, that.branchID) && Objects.equals(title, that.title) && Objects.equals(worktime, that.worktime) && Objects.equals(jobField, that.jobField) && Objects.equals(locationID, that.locationID) && jobType == that.jobType && Objects.equals(salaryLeast, that.salaryLeast) && Objects.equals(salaryGreatest, that.salaryGreatest) && Objects.equals(deadlineDate, that.deadlineDate) && Objects.equals(jobTitle, that.jobTitle) && jobLevel == that.jobLevel && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(jobRequirement, that.jobRequirement) && Objects.equals(jobBenefit, that.jobBenefit) && Objects.equals(groupID, that.groupID) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(currentCVs, that.currentCVs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobID, branchID, title, worktime, jobField, locationID, jobType, salaryLeast, salaryGreatest, deadlineDate, jobTitle, jobLevel, jobDescription, jobRequirement, jobBenefit, groupID, createdAt, updatedAt, currentCVs);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("JobRequests{");
		sb.append("jobID=").append(jobID);
		sb.append(", branchID=").append(branchID);
		sb.append(", title='").append(title).append('\'');
		sb.append(", worktime='").append(worktime).append('\'');
		sb.append(", jobField='").append(jobField).append('\'');
		sb.append(", locationID=").append(locationID);
		sb.append(", jobType=").append(jobType);
		sb.append(", salaryLeast=").append(salaryLeast);
		sb.append(", salaryGreatest=").append(salaryGreatest);
		sb.append(", deadlineDate=").append(deadlineDate);
		sb.append(", jobTitle='").append(jobTitle).append('\'');
		sb.append(", jobLevel=").append(jobLevel);
		sb.append(", jobDescription='").append(jobDescription).append('\'');
		sb.append(", jobRequirement='").append(jobRequirement).append('\'');
		sb.append(", jobBenefit='").append(jobBenefit).append('\'');
		sb.append(", groupID=").append(groupID);
		sb.append(", createdAt=").append(createdAt);
		sb.append(", updatedAt=").append(updatedAt);
		sb.append(", currentCVs=").append(currentCVs);
		sb.append('}');
		return sb.toString();
	}
}
