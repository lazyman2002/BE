package org.model;

import java.util.Objects;

public class Personalities {
	private Integer personalityID;
	private Integer CVID;
	private String personalityName;
	private String detail;

	public Personalities() {}

	public Integer getPersonalityID() {
		return personalityID;
	}
	public Integer getCVID() {
		return CVID;
	}
	public String getPersonalityName() {
		return personalityName;
	}
	public String getDetail() {
		return detail;
	}

	public void setPersonalityID(Integer personalityID) {
		this.personalityID = personalityID;
	}
	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setPersonalityName(String personalityName) {
		this.personalityName = personalityName;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Personalities)) return false;
		Personalities that = (Personalities) o;
		return Objects.equals(personalityID, that.personalityID) && Objects.equals(CVID, that.CVID) && Objects.equals(personalityName, that.personalityName) && Objects.equals(detail, that.detail);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personalityID, CVID, personalityName, detail);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Personalities{");
		sb.append("personalityID=").append(personalityID);
		sb.append(", CVID=").append(CVID);
		sb.append(", personalityName='").append(personalityName).append('\'');
		sb.append(", detail='").append(detail).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
