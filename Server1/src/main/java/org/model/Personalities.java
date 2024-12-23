package org.model;

import java.util.Objects;

public class Personalities {
	private Integer CVID;
	private String personalityTitle;
	private String detail;
	private Integer personalityID;

	public Personalities() {
	}

	public Personalities(Integer CVID, String personalityTitle, String detail, Integer personalityID) {
		this.CVID = CVID;
		this.personalityTitle = personalityTitle;
		this.detail = detail;
		this.personalityID = personalityID;
	}

	public Integer getCVID() {
		return CVID;
	}
	public String getPersonalityTitle() {
		return personalityTitle;
	}
	public String getDetail() {
		return detail;
	}
	public Integer getPersonalityID() {
		return personalityID;
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
	public void setPersonalityID(Integer personalityID) {
		this.personalityID = personalityID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Personalities)) return false;
		Personalities that = (Personalities) o;
		return Objects.equals(CVID, that.CVID) && Objects.equals(personalityTitle, that.personalityTitle) && Objects.equals(detail, that.detail) && Objects.equals(personalityID, that.personalityID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, personalityTitle, detail, personalityID);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Personalities{");
		sb.append("CVID=").append(CVID);
		sb.append(", personalityTitle='").append(personalityTitle).append('\'');
		sb.append(", detail='").append(detail).append('\'');
		sb.append(", personalityID=").append(personalityID);
		sb.append('}');
		return sb.toString();
	}
}
