package org.app;

public enum JobLevel {
	ENTRY_LEVEL("Entry Level"),
	MID_LEVEL("Mid Level"),
	SENIOR_LEVEL("Senior Level"),
	MANAGER("Manager"),
	DIRECTOR("Director"),
	EXECUTIVE("Executive");

	private final String displayName;

	// Constructor
	JobLevel(String displayName) {
		this.displayName = displayName;
	}

	// Phương thức để lấy giá trị chuỗi
	public String getDisplayName() {
		return displayName;
	}
}
