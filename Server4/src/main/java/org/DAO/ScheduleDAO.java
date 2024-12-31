package org.DAO;


import org.model.Schedules;
import proto.ServerChat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheduleDAO {
    public ArrayList<Schedules> readScheduleList(ServerChat.GroupMetaInfo request, Connection connection) throws Exception {
        System.out.println("readScheduleList");

        String query = "SELECT * FROM `Schedules` WHERE `Schedules`.`groupID` = ?;";
        ArrayList<Schedules> scheduleList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getGroupID() == 0) throw new Exception("GroupID is missing");
            preparedStatement.setInt(1, request.getGroupID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Schedules schedule = new Schedules();
                schedule.setGroupID(request.getGroupID());

                Integer scheduleID = resultSet.getInt("scheduleID");
                if (scheduleID <= 0) throw new Exception("ScheduleID is invalid");
                schedule.setScheduleID(scheduleID);

                Timestamp timeSet = resultSet.getTimestamp("timeSet");
                schedule.setTimeSet(timeSet);

                boolean isRecorded = resultSet.getBoolean("isRecorded");
                schedule.setRecored(isRecorded);

                scheduleList.add(schedule);
            }
            return scheduleList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Schedules readSchedule(ServerChat.ScheduleFullInfo request, Connection connection) throws Exception {
        System.out.println("readSchedule");

        String query = "SELECT * FROM `Schedules` WHERE `Schedules`.`scheduleID` = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, request.getScheduleID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer groupID = resultSet.getInt("groupID");
                if (groupID <= 0) throw new Exception("Invalid groupID");

                Timestamp timeSet = resultSet.getTimestamp("timeSet");
                boolean isRecorded = resultSet.getBoolean("isRecorded");

                Schedules schedule = new Schedules();

                // Set values individually
                schedule.setScheduleID(request.getScheduleID());
                schedule.setGroupID(groupID);
                schedule.setTimeSet(timeSet);
                schedule.setRecored(isRecorded);

                return schedule;
            } else {
                throw new Exception("Schedule not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Schedules registerSchedule(ServerChat.ScheduleFullInfo request, Connection connection) throws Exception {
        System.out.println("registerSchedule");

        String query = "INSERT INTO `Schedules`(`groupID`, `timeSet`, `isRecorded`) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getGroupID() == 0) {
                throw new Exception("Invalid GroupID");
            }

            // Optionally, validate other fields if needed
            Timestamp timeSet = request.hasTimeSet() ? new Timestamp(request.getTimeSet().getSeconds() * 1000) : null;
            boolean isRecorded = request.getIsRecorded() ? request.getIsRecorded() : false;

            // Set values for the prepared statement
            preparedStatement.setInt(1, request.getGroupID());
            preparedStatement.setTimestamp(2, timeSet);
            preparedStatement.setBoolean(3, isRecorded);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer scheduleID;
                if (resultSet.next()) {
                    scheduleID = resultSet.getInt(1);
                    return this.readSchedule(ServerChat.ScheduleFullInfo
                                    .newBuilder()
                                    .setScheduleID(scheduleID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Failed to add schedule");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Unexpected error occurred");
    }

    public Schedules updateSchedule(ServerChat.ScheduleFullInfo request, Connection connection) throws Exception {
        System.out.println("updateSchedule");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Schedules` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            // Check and add fields to update in the query
            if (request.hasTimeSet()) {
                java.sql.Timestamp timeSet = new java.sql.Timestamp(request.getTimeSet().getSeconds() * 1000);
                sb.append("`Schedules`.`timeSet` = ?, ");
                parameters.add(timeSet);
            }

            if (request.getIsRecorded()) {
                boolean isRecorded = request.getIsRecorded();
                sb.append("`Schedules`.`isRecorded` = ?, ");
                parameters.add(isRecorded);
            }

            // Validate scheduleID
            if (request.getScheduleID() == 0) {
                throw new Exception("Missing scheduleID");
            }

            // Remove the last comma and space, then append the WHERE clause
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Schedules`.`scheduleID` = ?;");
            parameters.add(request.getScheduleID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters in the prepared statement
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            // Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readSchedule(ServerChat.ScheduleFullInfo.newBuilder()
                                .setScheduleID(request.getScheduleID())
                                .build(),
                        connection);
            }
            throw new Exception("Update failed");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteSchedule(ServerChat.ScheduleFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteSchedule");

        String query = "DELETE FROM `Schedules` WHERE `Schedules`.`scheduleID` = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getScheduleID() == 0) throw new Exception("Missing scheduleID");

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, request.getScheduleID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("ScheduleID not found in the database");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashMap<Integer, Integer> readInterviewerList(Integer scheduleID, Connection connection) throws Exception {
        System.out.println("readInterviewerList");

        String query = "SELECT interviewOrder, userID FROM `Interviewers` WHERE `scheduleID` = ?;";

        HashMap<Integer, Integer> interviewerList = new HashMap<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            if (scheduleID == null || scheduleID <= 0) {
                throw new Exception("Invalid scheduleID");
            }
            preparedStatement.setInt(1, scheduleID);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer interviewOrder = resultSet.getInt("interviewOrder");
                Integer userID = resultSet.getInt("userID");

                interviewerList.put(interviewOrder, userID);
            }
            return interviewerList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public void appendInterviewer(Integer scheduleID, Integer userID, Connection connection) throws Exception {
        System.out.println("appendInterviewer");

        String sql = "INSERT INTO Interviewers (scheduleID, userID) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scheduleID);
            preparedStatement.setInt(2, userID);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Interviewer successfully appended.");
            } else {
                System.out.println("Failed to append interviewer.");
            }
        } catch (Exception e) {
            throw new Exception("Error appending interviewer", e);
        }
    }

    public void deleteInterviewer(Integer scheduleID, Integer userID, Connection connection) throws Exception {
        System.out.println("deleteInterviewer");

        String sql = "DELETE FROM Interviewers WHERE scheduleID = ? AND userID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scheduleID);
            preparedStatement.setInt(2, userID);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Interviewer successfully deleted.");
            } else {
                System.out.println("No matching interviewer found to delete.");
            }
        } catch (Exception e) {
            throw new Exception("Error deleting interviewer", e);
        }
    }
}
