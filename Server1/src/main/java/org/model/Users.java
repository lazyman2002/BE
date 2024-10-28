package org.model;

import org.connectConfig.HikariDataSource;

import java.sql.*;
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

	private boolean isCandidate;

	public Users(){};
	public Users(int userID,
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
//		this.GoogleToken = null;
//		this.GoogleTokenExpiration = Date.valueOf("1010-10-10");
//		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
//		this.updatedAt = this.createdAt;
//		currentID +=1;
	}

	public Users(String username, String password_hashed, Boolean isCandidate, String email) {
		this.username = username;
		this.password_hashed = password_hashed;
		this.isCandidate = isCandidate;
		this.email = email;
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
//	public Timestamp getCreatedAt() {
//		return createdAt;
//	}
//	public Timestamp getUpdatedAt() {
//		return updatedAt;
//	}
	public boolean isCandidate() {
		return isCandidate;
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
//	public void setGoogleTokenExpiration(Date googleTokenExpiration) {
//		GoogleTokenExpiration = googleTokenExpiration;
//	}
//	public void setCreatedAt(Timestamp createdAt) {
//		this.createdAt = createdAt;
//	}
//	public void setUpdatedAt(Timestamp updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	public void setCandidate(boolean candidate) {
		isCandidate = candidate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Users users)) return false;
        return userID == users.userID &&
				Objects.equals(username, users.username) &&
				Objects.equals(password_hashed, users.password_hashed) &&
				Objects.equals(firstName, users.firstName) &&
				Objects.equals(lastName, users.lastName) &&
				Objects.equals(email, users.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userID, username, password_hashed, firstName, lastName, email);
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
		sb.append('}');
		return sb.toString();
	}

	public String signup(String username, String password_hashed){
		String checkExist = "SELECT * FROM `Users` WHERE `Users`.`username` = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try{
			connection = HikariDataSource.getConnection();
			preparedStatement = connection.prepareStatement(checkExist);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			// Xử lý kết quả ở đây
			if (resultSet.next()) {
				return "tồn tại";
			} else {
				String newUsers = "SELECT * FROM `Users` WHERE `Users`.`username` = ?";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "?";
	}
	public Users login(String username, String password_hashed){
		String getLogin = "SELECT * FROM `Users` WHERE `Users`.`username` = ? AND `Users`.`password_hashed` = ?;";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = HikariDataSource.getConnection();
			preparedStatement = connection.prepareStatement(getLogin);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password_hashed);
			resultSet = preparedStatement.executeQuery();

			// Xử lý kết quả ở đây
			if (resultSet.next()) { // Kiểm tra xem có kết quả không
				int userID = resultSet.getInt("userID"); // Lấy userID
				String userName = resultSet.getString("username"); // Lấy username
				String passWord = resultSet.getString("password_hashed"); // Lấy username
				String firstName = resultSet.getString("firstName"); // Lấy firstName
				String lastName = resultSet.getString("lastName"); // Lấy lastName
				String email = resultSet.getString("email"); // Lấy email
				Boolean isCandidate = resultSet.getBoolean("isCandidate"); // Lấy isCandidate

				return new Users(userID, userName, passWord, firstName, lastName, email, isCandidate);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
