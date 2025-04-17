package org.model;

import java.sql.Date;
import java.util.Objects;

public class Certifications {
	private Integer CVID;
	private Integer certificationID;
	private String certificationName;
	private String provider;
	private Date providedDate;

	public Certifications() {}

	public Integer getCVID() {
		return CVID;
	}
	public String getCertificationName() {
		return certificationName;
	}
	public String getProvider() {
		return provider;
	}
	public Date getProvidedDate() {
		return providedDate;
	}
	public Integer getCertificationID() {
		return certificationID;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setProvidedDate(Date providedDate) {
		this.providedDate = providedDate;
	}
	public void setCertificationID(Integer certificationID) {
		this.certificationID = certificationID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Certifications)) return false;
		Certifications that = (Certifications) o;
		return Objects.equals(CVID, that.CVID) && Objects.equals(certificationName, that.certificationName) && Objects.equals(provider, that.provider) && Objects.equals(providedDate, that.providedDate) && Objects.equals(certificationID, that.certificationID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, certificationName, provider, providedDate, certificationID);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Certifications{");
		sb.append("CVID=").append(CVID);
		sb.append(", certificationName='").append(certificationName).append('\'');
		sb.append(", provider='").append(provider).append('\'');
		sb.append(", providedDate=").append(providedDate);
		sb.append(", certificationID=").append(certificationID);
		sb.append('}');
		return sb.toString();
	}
}
