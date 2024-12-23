package org.model;

import proto.ServerClient;

public enum Gender {
	MALE("MALE"),
	FEMALE("FEMALE");

	private final String displayName;

	Gender(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static Gender fromProto(ServerClient.Gender protoGender) {
		if (protoGender == null) {
			throw new IllegalArgumentException("protoGender cannot be null");
		}
		switch (protoGender) {
			case MALE:
				return Gender.MALE;
			case FEMALE:
				return Gender.FEMALE;
			default:
				throw new IllegalArgumentException("Unknown Gender: " + protoGender);
		}
	}

	public ServerClient.Gender toProto() {
		switch (this) {
			case MALE:
				return ServerClient.Gender.MALE;
			case FEMALE:
				return ServerClient.Gender.FEMALE;
			default:
				throw new IllegalArgumentException("Unknown Gender: " + this);
		}
	}

}
