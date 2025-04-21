package org.controller;

import org.connectConfig.HikariDataSource;
import proto.ServerChat;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

public class ScheduleController {
    /*
    public ArrayList<Schedules> scheduleList(ServerChat.GroupMetaInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return scheduleDAO.readScheduleList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }


     */
    /*
    public Schedules scheduleRead(ServerChat.ScheduleFullInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Schedules schedule = scheduleDAO.readSchedule(request, connection);
            schedule.setInterviewers(scheduleDAO.readInterviewerList(schedule.getScheduleID(), connection));
            connection.commit();
            return schedule;
        } finally {
            if (connection != null) connection.close();
        }
    }


     */
    /*
    public Schedules scheduleUpdate(ServerChat.ScheduleFullInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Schedules schedule = scheduleDAO.updateSchedule(request, connection);
            connection.commit();
            return schedule;
        } finally {
            if (connection != null) connection.close();
        }
    }


     */
    /*
    public Schedules scheduleCreate(ServerChat.ScheduleFullInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Schedules schedule = scheduleDAO.registerSchedule(request, connection);
            connection.commit();
            return schedule;
        } finally {
            if (connection != null) connection.close();
        }
    }


     */
    /*
    public Boolean scheduleDelete(ServerChat.ScheduleFullInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (scheduleDAO.deleteSchedule(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }


     */
    /*
    public void scheduleAppendInterviewer(ServerChat.ScheduleFullInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Integer scheduleID = request.getScheduleID();
            Map<Integer, Integer> hashMap = request.getInterviewersMap();

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                Integer userID = entry.getValue();
                scheduleDAO.appendInterviewer(scheduleID, userID, connection);
            }
            connection.commit();
        } finally {
            if (connection != null) connection.close();
        }
    }


     */
    /*
    public void scheduleDeleteInterviewer(ServerChat.ScheduleFullInfo request) throws Exception {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Integer scheduleID = request.getScheduleID();
            Map<Integer, Integer> hashMap = request.getInterviewersMap();

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                Integer userID = entry.getValue();
                scheduleDAO.deleteInterviewer(scheduleID, userID, connection);
            }
            connection.commit();
        } finally {
            if (connection != null) connection.close();
        }
    }

     */
}
