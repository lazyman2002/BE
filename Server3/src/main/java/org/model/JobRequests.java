package org.app;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class JobRequests {
	private int jobID;
	private JobType jobType;
	private int salaryLeast;
	private int salaryGreatest;
	private char currency;
	private String jobTitle;
	private JobLevel jobLevel;
	private String jobDescription;
	private Date deadlineDate;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private ConcurrentHashMap<Integer, Boolean> currentCVs;

	private static int currentID = 1;

	public int getJobID() {
		return jobID;
	}
	public JobType getJobType() {
		return jobType;
	}
	public int getSalaryLeast() {
		return salaryLeast;
	}
	public int getSalaryGreatest() {
		return salaryGreatest;
	}
	public char getCurrency() {
		return currency;
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
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public ConcurrentHashMap<Integer, Boolean> getCurrentCVs() {
		return currentCVs;
	}
	public static int getCurrentID() {
		return currentID;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public void setSalaryLeast(int salaryLeast) {
		this.salaryLeast = salaryLeast;
	}
	public void setSalaryGreatest(int salaryGreatest) {
		this.salaryGreatest = salaryGreatest;
	}
	public void setCurrency(char currency) {
		this.currency = currency;
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
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setCurrentCVs(ConcurrentHashMap<Integer, Boolean> currentCVs) {
		this.currentCVs = currentCVs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JobRequests that = (JobRequests) o;
		return jobID == that.jobID && salaryLeast == that.salaryLeast && salaryGreatest == that.salaryGreatest && currency == that.currency && jobType == that.jobType && Objects.equals(jobTitle, that.jobTitle) && jobLevel == that.jobLevel && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(deadlineDate, that.deadlineDate) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobID, jobType, salaryLeast, salaryGreatest, currency, jobTitle, jobLevel, jobDescription, deadlineDate, createdAt, updatedAt);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("JobRequests{");
		sb.append("jobID=").append(jobID);
		sb.append(", jobType=").append(jobType);
		sb.append(", salaryLeast=").append(salaryLeast);
		sb.append(", salaryGreatest=").append(salaryGreatest);
		sb.append(", currency=").append(currency);
		sb.append(", jobTitle='").append(jobTitle).append('\'');
		sb.append(", jobLevel=").append(jobLevel);
		sb.append(", jobDescription='").append(jobDescription).append('\'');
		sb.append(", deadlineDate=").append(deadlineDate);
		sb.append(", createdAt=").append(createdAt);
		sb.append(", updatedAt=").append(updatedAt);
		sb.append(", currentCVs=").append(currentCVs);
		sb.append('}');
		return sb.toString();
	}
}
