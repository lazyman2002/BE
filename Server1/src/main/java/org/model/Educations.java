package org.model;

import java.sql.Date;
import java.util.Objects;

public class Educations {
	private Integer educationID;
	private Integer CVID;
	private String degree;
	private String EduFields;
	private String EduDescription;
	private Date startDate;
	private Date endDate;

	public Educations() {}

	public Integer getCVID() {
		return CVID;
	}
	public String getDegree() {
		return degree;
	}
	public String getEduFields() {
		return EduFields;
	}
	public String getEduDescription() {
		return EduDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Integer getEducationID() {
		return educationID;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setEduFields(String eduFields) {
		EduFields = eduFields;
	}
	public void setEduDescription(String eduDescription) {
		EduDescription = eduDescription;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setEducationID(Integer educationID) {
		this.educationID = educationID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Educations)) return false;
		Educations that = (Educations) o;
		return Objects.equals(educationID, that.educationID) && Objects.equals(CVID, that.CVID) && Objects.equals(degree, that.degree) && Objects.equals(EduFields, that.EduFields) && Objects.equals(EduDescription, that.EduDescription) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(educationID, CVID, degree, EduFields, EduDescription, startDate, endDate);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Educations{");
		sb.append("educationID=").append(educationID);
		sb.append(", CVID=").append(CVID);
		sb.append(", degree='").append(degree).append('\'');
		sb.append(", EduFields='").append(EduFields).append('\'');
		sb.append(", EduDescription='").append(EduDescription).append('\'');
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append('}');
		return sb.toString();
	}
}
