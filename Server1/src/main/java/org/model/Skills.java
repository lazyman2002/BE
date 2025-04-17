package org.model;

import java.util.Objects;

public class Skills {
	private Integer CVID;
	private Integer skillID;
	private String skillName;
	private Proficiency proficiency;

	public Skills() {}

	public Integer getCVID() {
		return CVID;
	}
	public Integer getSkillID() {
		return skillID;
	}
	public String getSkillName() {
		return skillName;
	}
	public Proficiency getProficiency() {
		return proficiency;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public void setProficiency(Proficiency proficiency) {
		this.proficiency = proficiency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Skills)) return false;
		Skills skills = (Skills) o;
		return Objects.equals(CVID, skills.CVID) && Objects.equals(skillName, skills.skillName) && proficiency == skills.proficiency && Objects.equals(skillID, skills.skillID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, skillName, proficiency, skillID);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Skills{");
		sb.append("CVID=").append(CVID);
		sb.append(", skillName='").append(skillName).append('\'');
		sb.append(", proficiency=").append(proficiency);
		sb.append(", skillID=").append(skillID);
		sb.append('}');
		return sb.toString();
	}
}
