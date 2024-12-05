package org.app;

import java.sql.Date;
import java.util.Objects;

public class Educations {
	private Integer CVID;
	private String degree;
	private String fieldOfStudy;
	private String institution;
	private Date startDate;
	private Date endDate;

	public Integer getCVID() {
		return CVID;
	}

	public String getDegree() {
		return degree;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public String getInstitution() {
		return institution;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Educations that)) return false;
        return Objects.equals(CVID, that.CVID) && Objects.equals(degree, that.degree) && Objects.equals(fieldOfStudy, that.fieldOfStudy) && Objects.equals(institution, that.institution) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, degree, fieldOfStudy, institution, startDate, endDate);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Educations{");
		sb.append("CVID=").append(CVID);
		sb.append(", degree='").append(degree).append('\'');
		sb.append(", fieldOfStudy='").append(fieldOfStudy).append('\'');
		sb.append(", institution='").append(institution).append('\'');
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append('}');
		return sb.toString();
	}
}
