package org.app;

import java.sql.Date;
import java.util.Objects;

public class Educations {
	private int degree;
	private String fields;
	private String institution;
	private Date startDate;
	private Date endDate;

	public Educations(int degree, String fields, String institution, Date startDate, Date endDate) {
		this.degree = degree;
		this.fields = fields;
		this.institution = institution;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getDegree() {
		return degree;
	}
	public String getFields() {
		return fields;
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

	public void setDegree(int degree) {
		this.degree = degree;
	}
	public void setFields(String fields) {
		this.fields = fields;
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
		if (o == null || getClass() != o.getClass()) return false;
		Educations that = (Educations) o;
		return degree == that.degree && Objects.equals(fields, that.fields) && Objects.equals(institution, that.institution) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(degree, fields, institution, startDate, endDate);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Educations{");
		sb.append("degree=").append(degree);
		sb.append(", fields='").append(fields).append('\'');
		sb.append(", institution='").append(institution).append('\'');
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append('}');
		return sb.toString();
	}
}
