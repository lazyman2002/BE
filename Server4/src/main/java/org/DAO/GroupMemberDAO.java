package org.DAO;

import org.model.Groups;
import proto.ServerChat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupMemberDAO {
    public void createGroup(ServerChat.GroupMetaInfo request, Integer groupID, Connection connection) throws Exception {
        System.out.println("createGroup");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `GroupMembers`(`userID`, `groupID`, `isAdmin`) VALUES (?, ?, true);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            Integer useID = request.getGroupCreaterID();
            if(useID == null || useID == 0)  throw new Exception("User ID không hợp lệ");
            preparedStatement.setInt(1, useID);

            if(groupID == null || groupID == 0) throw new Exception("Group ID không hợp lệ");
            preparedStatement.setInt(2, groupID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                    return;
            } else {
                throw new Exception("Không thêm chứng chỉ thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<Groups> readGroupList(ServerChat.GroupMember request, Connection connection) throws Exception {
        System.out.println("readGroupList");

        String query = "SELECT * FROM `GroupMembers` WHERE `GroupMembers`.`userID` = ?;";
        ArrayList<Groups> skillsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getUserID() == 0) throw new Exception("userID is missing");
            preparedStatement.setInt(1, request.getUserID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Groups skills = new Groups();

                Integer skillID = resultSet.getInt("groupID");
                if (skillID <= 0) throw new Exception("groupID returned is not valid");
                skills.setGroupID(skillID);
                skillsList.add(skills);
            }
            return skillsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteMember(ServerChat.GroupMember request, Connection connection) throws Exception {
        System.out.println("deleteMember");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `GroupMembers` WHERE `GroupMembers`.`userID` = ? && `GroupMembers`.`groupID` = ? && `GroupMembers`.`isAdmin` = false;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getUserID() == 0) throw new Exception("Không có userID");
            if (request.getGroupID() == 0) throw new Exception("Không có groupID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getUserID());
            preparedStatement.setInt(2, request.getGroupID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("Không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Groups appendMemeber(ServerChat.GroupMember request, Connection connection) throws Exception {
        System.out.println("appendMemeber");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `GroupMembers`(`userID`, `groupID`, `isAdmin`) VALUES (?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            Integer userID = request.getUserID();
            if(userID == null || userID == 0)   throw new Exception("userID khong hop le");
            preparedStatement.setInt(1, userID);
            Integer groupID = request.getGroupID();
            if(groupID == null || groupID == 0)   throw new Exception("groupID khong hop le");
            preparedStatement.setInt(2, groupID);
            preparedStatement.setBoolean(3, request.getIsAdmin());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                GroupDAO groupDAO = new GroupDAO();
                return groupDAO.readGroup(ServerChat.GroupMetaInfo.newBuilder().setGroupID(request.getGroupID()).build(), connection);
            } else {
                throw new Exception("Không thêm chứng chỉ thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean checkInGroup(Integer userId, Integer groupId, Connection connection) throws Exception {
        System.out.println("checkInGroup");

        String sql = "SELECT COUNT(*) FROM `GroupMembers` WHERE `userID` = ? AND `groupID` = ?";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, groupId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        return  false;
    }

    public ArrayList<ServerChat.GroupMember> readGroupMemberList(ServerChat.GroupMetaInfo request, Connection connection) throws Exception {
        System.out.println("readGroupMemberList");

        String query = "SELECT `userID`, `isAdmin` FROM `GroupMembers` WHERE `GroupMembers`.`groupID` = ?;";
        ArrayList<ServerChat.GroupMember> memberList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getGroupID() == 0) throw new Exception("groupID is missing");
            preparedStatement.setInt(1, request.getGroupID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                if (userID <= 0) throw new Exception("userID returned is not valid");
                boolean isAdmin = resultSet.getBoolean("isAdmin");

                ServerChat.GroupMember groupMember = ServerChat.GroupMember.newBuilder()
                        .setUserID(userID)
                        .setIsAdmin(isAdmin)
                        .build();

                memberList.add(groupMember);
            }
            return memberList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

}
