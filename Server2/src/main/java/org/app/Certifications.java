package org.app;

import java.sql.Date;
import java.util.Objects;

public class Certifications {
	private Integer CVID;
	private String certificationName;
	private String provider;
	private Date providedDate;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Certifications that)) return false;
        return Objects.equals(CVID, that.CVID) && Objects.equals(certificationName, that.certificationName) && Objects.equals(provider, that.provider) && Objects.equals(providedDate, that.providedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, certificationName, provider, providedDate);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Certifications{");
		sb.append("CVID=").append(CVID);
		sb.append(", certificationName='").append(certificationName).append('\'');
		sb.append(", provider='").append(provider).append('\'');
		sb.append(", providedDate=").append(providedDate);
		sb.append('}');
		return sb.toString();
	}
}
