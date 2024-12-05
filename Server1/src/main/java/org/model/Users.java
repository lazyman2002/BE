package org.model;

import java.sql.*;
import java.util.Objects;

public class Users {
	private Integer userID;
	private String username;
	private String password_hashed;
	private String firstName;
	private String lastName;
	private String email;
	private String GoogleToken;
	private Timestamp GoogleTokenExpiration;
	private Timestamp createdAt;
	private Timestamp updatedAt;
//  ngoài CSDL
	private boolean isCandidate;
//	private String password;

	public Users(){}
	public Users(Integer userID,
				String username,
				String password_hashed,
				String firstName,
				String lastName,
				String email,
				Boolean isCandidate) {
		this.userID = userID;
		this.username = username;
		this.password_hashed = password_hashed;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isCandidate = isCandidate;
	}

	public Integer getUserID() {
		return userID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword_hashed() {
		return password_hashed;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getGoogleToken() {
		return GoogleToken;
	}
	public Timestamp getGoogleTokenExpiration() {
		return GoogleTokenExpiration;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public boolean isCandidate() {
		return isCandidate;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword_hashed(String password_hashed) {
		this.password_hashed = password_hashed;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGoogleToken(String googleToken) {
		GoogleToken = googleToken;
	}
	public void setGoogleTokenExpiration(Timestamp googleTokenExpiration) {
		GoogleTokenExpiration = googleTokenExpiration;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setCandidate(boolean candidate) {
		isCandidate = candidate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Users users = (Users) o;
		return Objects.equals(userID, users.userID) && Objects.equals(username, users.username) && Objects.equals(password_hashed, users.password_hashed) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(GoogleToken, users.GoogleToken) && Objects.equals(GoogleTokenExpiration, users.GoogleTokenExpiration) && Objects.equals(createdAt, users.createdAt) && Objects.equals(updatedAt, users.updatedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userID, username, password_hashed, firstName, lastName, email, GoogleToken, GoogleTokenExpiration, createdAt, updatedAt);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Users{");
		sb.append("userID=").append(userID);
		sb.append(", username='").append(username).append('\'');
		sb.append(", password_hashed='").append(password_hashed).append('\'');
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", GoogleToken='").append(GoogleToken).append('\'');
		sb.append(", GoogleTokenExpiration=").append(GoogleTokenExpiration);
		sb.append(", createdAt=").append(createdAt);
		sb.append(", updatedAt=").append(updatedAt);
		sb.append(", isCandidate=").append(isCandidate);
		sb.append('}');
		return sb.toString();
	}
}