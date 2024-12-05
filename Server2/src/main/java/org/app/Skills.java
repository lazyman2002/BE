package org.app;

import java.util.Objects;

public class Skills {
	private Integer CVID;
	private String skillName;
	private Proficiency proficiency;

	public Integer getCVID() {
		return CVID;
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
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public void setProficiency(Proficiency proficiency) {
		this.proficiency = proficiency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Skills skills)) return false;
        return Objects.equals(CVID, skills.CVID) && Objects.equals(skillName, skills.skillName) && proficiency == skills.proficiency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, skillName, proficiency);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Skills{");
		sb.append("CVID=").append(CVID);
		sb.append(", skillName='").append(skillName).append('\'');
		sb.append(", proficiency=").append(proficiency);
		sb.append('}');
		return sb.toString();
	}
}
