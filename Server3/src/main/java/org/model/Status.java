package org.app;

public enum Status {
	APPLICATION_REVIEW("Vòng hồ sơ"),
	INTERVIEW("Vòng phỏng vấn"),
	SUCCESS("Thành công"),
	FAILURE("Thất bại");

	private final String displayName;

	// Constructor
	Status(String displayName) {
		this.displayName = displayName;
	}

	// Phương thức để lấy giá trị chuỗi
	public String getDisplayName() {
		return displayName;
	}
}
