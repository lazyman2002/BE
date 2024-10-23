package org.app;

import java.sql.Date;
import java.util.Objects;

public class Certifications {
	private int certificationName;
	private int provider;
	private Date providedDate;

	public Certifications(int certificationName, int provider, Date providedDate) {
		this.certificationName = certificationName;
		this.provider = provider;
		this.providedDate = providedDate;
	}

	public int getCertificationName() {
		return certificationName;
	}
	public int getProvider() {
		return provider;
	}
	public Date getProvidedDate() {
		return providedDate;
	}

	public void setCertificationName(int certificationName) {
		this.certificationName = certificationName;
	}
	public void setProvider(int provider) {
		this.provider = provider;
	}
	public void setProvidedDate(Date providedDate) {
		this.providedDate = providedDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Certifications that = (Certifications) o;
		return certificationName == that.certificationName && provider == that.provider && Objects.equals(providedDate, that.providedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificationName, provider, providedDate);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Certifications{");
		sb.append("certificationName=").append(certificationName);
		sb.append(", provider=").append(provider);
		sb.append(", providedDate=").append(providedDate);
		sb.append('}');
		return sb.toString();
	}
}
