package org.app;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Users {
	private int userID;
	private String username;
	private String password_hashed;
	private String firstName;
	private String lastName;
	private String email;
	private String GoogleToken;
	private Date GoogleTokenExpiration;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	private static int currentID = 1;

	public Users(String username,
				 String password_hashed,
				 String firstName,
				 String lastName,
				 String email) {
		this.userID = currentID;
		this.username = username;
		this.password_hashed = password_hashed;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.GoogleToken = null;
		this.GoogleTokenExpiration = Date.valueOf("1010-10-10");
		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
		this.updatedAt = this.createdAt;
		currentID +=1;
	}

	public int getUserID() {
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
	public Date getGoogleTokenExpiration() {
		return GoogleTokenExpiration;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUserID(int userID) {
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
	public void setGoogleTokenExpiration(Date googleTokenExpiration) {
		GoogleTokenExpiration = googleTokenExpiration;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Users users)) return false;
        return userID == users.userID && Objects.equals(username, users.username) && Objects.equals(password_hashed, users.password_hashed) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(createdAt, users.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userID, username, password_hashed, firstName, lastName, email, createdAt);
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
		sb.append('}');
		return sb.toString();
	}
}
