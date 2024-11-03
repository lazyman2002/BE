package org.model;

public enum JobType {
	FULLTIME("Full Time"),
	HALFTIME("Half Time");

	private final String displayName;

	JobType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
