package org.app;

import java.util.Objects;

public class Personalities {
	private String personalityTitle;
	private String description;

	public String getPersonalityTitle() {
		return personalityTitle;
	}
	public String getDescription() {
		return description;
	}

	public void setPersonalityTitle(String personalityTitle) {
		this.personalityTitle = personalityTitle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Personalities that = (Personalities) o;
		return Objects.equals(personalityTitle, that.personalityTitle) && Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personalityTitle, description);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Personalities{");
		sb.append("personalityTitle='").append(personalityTitle).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
