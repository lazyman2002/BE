package org.app;

import java.util.Objects;

public class Skills {
	private String skillName;
	private Proficiency proficiency;

	public String getSkillName() {
		return skillName;
	}
	public Proficiency getProficiency() {
		return proficiency;
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
		if (o == null || getClass() != o.getClass()) return false;
		Skills skills = (Skills) o;
		return Objects.equals(skillName, skills.skillName) && proficiency == skills.proficiency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(skillName, proficiency);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Skills{");
		sb.append("skillName='").append(skillName).append('\'');
		sb.append(", proficiency=").append(proficiency);
		sb.append('}');
		return sb.toString();
	}
}
