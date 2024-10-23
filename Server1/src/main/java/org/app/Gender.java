package org.app;

public enum Gender {
	MALE("Male"),
	FEMALE("Female");

	private final String displayName;

	// Constructor to assign the display name
	Gender(String displayName) {
		this.displayName = displayName;
	}

	// Getter to access the display name
	public String getDisplayName() {
		return displayName;
	}
}
