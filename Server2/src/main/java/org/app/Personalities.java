package org.app;

import java.util.Objects;

public class Personalities {
	private Integer CVID;
	private String personalityTitle;
	private String detail;

	public Integer getCVID() {
		return CVID;
	}
	public String getPersonalityTitle() {
		return personalityTitle;
	}
	public String getDetail() {
		return detail;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setPersonalityTitle(String personalityTitle) {
		this.personalityTitle = personalityTitle;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Personalities that)) return false;
        return Objects.equals(CVID, that.CVID) && Objects.equals(personalityTitle, that.personalityTitle) && Objects.equals(detail, that.detail);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, personalityTitle, detail);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Personalities{");
		sb.append("CVID=").append(CVID);
		sb.append(", personalityTitle='").append(personalityTitle).append('\'');
		sb.append(", detail='").append(detail).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
