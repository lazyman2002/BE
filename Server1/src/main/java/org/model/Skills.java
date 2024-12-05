package org.model;

import java.util.Objects;

public class Skills {
	private Integer CVID;
	private String skillName;
	private Proficiency proficiency;
	private Integer skillID;

	public Skills() {}

	public Skills(Integer CVID, String skillName, Proficiency proficiency, Integer skillID) {
		this.CVID = CVID;
		this.skillName = skillName;
		this.proficiency = proficiency;
		this.skillID = skillID;
	}

	public Integer getCVID() {
		return CVID;
	}
	public String getSkillName() {
		return skillName;
	}
	public Proficiency getProficiency() {
		return proficiency;
	}
	public Integer getSkillID() {
		return skillID;
	}

	public void setCVID(Integer CVID) {
		this.CVID = CVID;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public void setProficiency(Proficiency proficiency) {
		this.proficiency = proficiency;
	}
	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Skills skills)) return false;
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
