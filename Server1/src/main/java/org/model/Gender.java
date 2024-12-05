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
        return switch (protoGender) {
            case MALE -> Gender.MALE;
            case FEMALE -> Gender.FEMALE;
            default -> throw new IllegalArgumentException("Unknown Gender: " + protoGender);
        };
	}

	public ServerClient.Gender toProto() {
        return switch (this) {
            case MALE -> ServerClient.Gender.MALE;
            case FEMALE -> ServerClient.Gender.FEMALE;
            default -> throw new IllegalArgumentException("Unknown Gender: " + this);
        };
	}
}
