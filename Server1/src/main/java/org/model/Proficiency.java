package org.model;

public enum Proficiency {
	BEGINNER("BEGINNER"),
	INTERMEDIATE("INTERMEDIATE"),
	EXPERT("EXPERT");

	private final String displayName;

	Proficiency(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
