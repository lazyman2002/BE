package org.model;

import java.sql.Date;
import java.util.Objects;
import java.util.HashSet;

public class Candidates extends Users {
	private Date birthDate;
	private Gender gender;

//	Ngoài CSDL
	private HashSet<Integer> currentCVs;
	public Candidates() {}
	public Candidates(Integer userID,
					  String username,
					  String password_hashed,
					  String firstName,
					  String lastName,
					  String email,
					  Boolean isCandidate) {
		super(userID, username, password_hashed, firstName, lastName, email, isCandidate);
	}

	public Candidates(Integer userID,
					  String username,
					  String password_hashed,
					  String firstName,
					  String lastName,
					  String email,
					  Boolean isCandidate,
					  Date birthDate,
					  Gender gender) {
		super(userID, username, password_hashed, firstName, lastName, email, isCandidate);
		this.birthDate = birthDate;
		this.gender = gender;
	}

	public Candidates(Users users){
		super(users.getUserID(), users.getUsername(), users.getPassword_hashed(), users.getFirstName(), users.getLastName(), users.getEmail(), users.isCandidate());
	}

	public Date getBirthDate() {
		return birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public HashSet<Integer> getCurrentCVs() {
		return currentCVs;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setCurrentCVs(HashSet<Integer> currentCVs) {
		this.currentCVs = currentCVs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Candidates that)) return false;
		if (!super.equals(o)) return false;
        return Objects.equals(birthDate, that.birthDate) && gender == that.gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), birthDate, gender);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Candidates{");
		sb.append("birthDate=").append(birthDate);
		sb.append(", gender=").append(gender);
		sb.append(", currentCVs=").append(currentCVs);
		sb.append('}');
		return sb.toString();
	}
}
