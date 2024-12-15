package org.DAO;

import org.model.Groups;
import proto.ServerChat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO {
    public Groups readGroup(ServerChat.GroupMetaInfo request, Connection connection) throws Exception {
        System.out.println("readGroup");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Groups` WHERE `Groups`.`groupID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            if( request.getGroupID() == 0)  throw new Exception("GroupIP không hợp lệ");

            preparedStatement.setInt(1, request.getGroupID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int groupID = resultSet.getInt("groupID");
                String groupName = resultSet.getString("groupName");

                return new Groups(
                        groupID,
                        groupName
                );
            } else {
                throw new Exception("Group not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Groups createGroup(ServerChat.GroupMetaInfo request, Connection connection) throws Exception {
        System.out.println("createGroup");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Groups`(`groupName`) VALUES (?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            String provider = request.getGroupName();
            if (provider == null || provider.isEmpty() || provider.isBlank()) {
                throw new Exception("Group name không được để trống");
            }
            preparedStatement.setString(1, provider);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer certificationID;
                if (resultSet.next()) {
                    certificationID = resultSet.getInt(1);
                    return new Groups(certificationID, provider);
                }
            } else {
                throw new Exception("Không thêm chứng chỉ thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Groups updateGroup(ServerChat.GroupMetaInfo request, Connection connection) throws Exception {
        System.out.println("updateGroup");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Groups` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (request.getGroupName() != null && !request.getGroupName().isBlank()) {
                sb.append("`Groups`.`groupName` = ?, ");
                parameters.add(request.getGroupName());
            }

            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Groups`.`groupID` = ?");
            parameters.add(request.getGroupID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readGroup(request, connection);
            }
            throw new Exception("Update failed");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteGroup(ServerChat.GroupMetaInfo request, Connection connection) throws Exception {
        System.out.println("deleteGroup");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Groups` WHERE `Groups`.`groupID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getGroupID() == 0) throw new Exception("Không có groupID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getGroupID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("groupID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }
}
