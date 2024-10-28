package org.model;

import java.sql.Date;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Candidates extends Users {
	private int candidateID;
	private Date birthDate;
	private Gender gender;
	private ConcurrentHashMap<Integer, Boolean> currentCVs;

	private static int currentID = 1;

	public Candidates(){};

	public Candidates(Users user) {
		super(user.getUserID(),
				user.getUsername(),
				user.getPassword_hashed(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.isCandidate());
	}

	public Candidates(int userID,
					  String username,
					  String password_hashed,
					  String firstName,
					  String lastName,
					  String email,
					  Boolean isCandidate,
					  int candidateID,
					  Date birthDate,
					  Gender gender) {
		super(userID, username, password_hashed, firstName, lastName, email, isCandidate);
		this.candidateID = candidateID;
		this.birthDate = birthDate;
		this.gender = gender;
	}

	public int getCandidateID() {
		return candidateID;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public ConcurrentHashMap<Integer, Boolean> getCurrentCVs() {
		return currentCVs;
	}

	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setCurrentCVs(ConcurrentHashMap<Integer, Boolean> currentCVs) {
		this.currentCVs = currentCVs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Candidates that = (Candidates) o;
		return candidateID == that.candidateID && Objects.equals(birthDate, that.birthDate) && gender == that.gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), candidateID, birthDate, gender);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Candidates{");
		sb.append("candidateID=").append(candidateID);
		sb.append(", birthDate=").append(birthDate);
		sb.append(", gender=").append(gender);
		sb.append(", currentCVs=").append(currentCVs);
		sb.append('}');
		return sb.toString();
	}
}
