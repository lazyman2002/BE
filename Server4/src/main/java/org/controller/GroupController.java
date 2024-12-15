package org.controller;

import org.DAO.GroupDAO;
import org.DAO.GroupMemberDAO;
import org.connectConfig.HikariDataSource;
import org.model.Groups;
import proto.ServerChat;

import java.sql.Connection;
import java.util.ArrayList;

public class GroupController {
    public ArrayList<Groups> groupList(ServerChat.GroupMember request) throws Exception {
        GroupMemberDAO groupMemberDAO = new GroupMemberDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return groupMemberDAO.readGroupList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Groups groupRead(ServerChat.GroupMetaInfo request) throws Exception {
        System.out.println("groupRead");

        GroupDAO groupDAO = new GroupDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Groups group = groupDAO.readGroup(request, connection);
            connection.commit();
            return group;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Groups groupUpdate(ServerChat.GroupMetaInfo request) throws Exception {
        GroupDAO groupDAO = new GroupDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Groups group = groupDAO.updateGroup(request, connection);
            connection.commit();
            return group;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Groups groupRegister(ServerChat.GroupMetaInfo request) throws Exception {
        GroupDAO groupDAO = new GroupDAO();
        GroupMemberDAO groupMemberDAO = new GroupMemberDAO();

        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Groups group = groupDAO.createGroup(request, connection);
            groupMemberDAO.createGroup(request, group.getGroupID(), connection);
            connection.commit();
            return group;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean groupDelete(ServerChat.GroupMetaInfo request) throws Exception {
        GroupDAO groupDAO = new GroupDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (groupDAO.deleteGroup(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean memberDelete(ServerChat.GroupMember request) throws Exception {
        GroupMemberDAO groupMemberDAO = new GroupMemberDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (groupMemberDAO.deleteMember(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Groups groupAppendMember(ServerChat.GroupMember request) throws Exception {
        GroupMemberDAO groupMemberDAO = new GroupMemberDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Groups group = groupMemberDAO.appendMemeber(request, connection);
            connection.commit();
            return group;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean checkInGroup(Integer userID, Integer groupID) throws Exception {
        GroupMemberDAO groupMemberDAO = new GroupMemberDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Boolean bool = groupMemberDAO.checkInGroup(userID, groupID, connection);
            connection.commit();
            return bool;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
