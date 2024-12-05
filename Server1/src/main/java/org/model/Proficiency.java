package org.model;

public enum Proficiency {
	BEGINNER("Beginner"),
	INTERMEDIATE("Intermediate"),
	EXPERT("Expert");

	private final String displayName;

	Proficiency(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
