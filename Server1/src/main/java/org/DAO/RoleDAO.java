package org.DAO;

import org.model.Roles;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    public ArrayList<Roles> readRoleList(ServerClient.CompanyMetaInfo request, Connection connection) throws Exception {
        System.out.println("readRoleList");

        String query = "SELECT * FROM `Roles` WHERE `Roles`.`companyID` = ?;";
        ArrayList<Roles> rolesList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if(request.getCompanyID() == 0) throw new Exception("không có CompanyID");
            preparedStatement.setInt(1, request.getCompanyID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Roles roles = new Roles();
                roles.setCompanyID(request.getCompanyID());
                Integer roleID = resultSet.getInt("roleID");
                if (resultSet.wasNull()) {
                    roles.setRoleID(null);
                } else {
                    roles.setRoleID(roleID);
                }

                String roleName = resultSet.getString("roleName");
                roles.setRoleName(roleName != null ? roleName : "");

                Integer roleLevel = resultSet.getInt("roleLevel");
                roles.setRoleLevel(roleLevel);

                rolesList.add(roles);
            }
            return rolesList;
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Roles readRole(ServerClient.RoleFullInfo request, Connection connection) throws Exception {
        System.out.println("readRole");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Roles` WHERE `Roles`.`roleID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getRoleID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int roleID = resultSet.getInt("roleID");
                int companyID = resultSet.getInt("companyID");
                if(companyID == 0)  throw new Exception("Role có CompanyID không hợp lệ");
                int roleLevel = resultSet.getInt("roleLevel");

                String roleName = resultSet.getString("roleName");
                roleName = (roleName != null) ? roleName : "";

                return new Roles(
                        roleID,
                        roleName,
                        roleLevel,
                        companyID
                );
            } else {
                throw new Exception("Không tìm được Roles");
            }
        }
        finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Roles updateRole(ServerClient.RoleFullInfo request, Connection connection) throws Exception{
        System.out.println("updateRole");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Roles` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if(request.getRoleName() != null && !request.getRoleName().isEmpty() && !request.getRoleName().isEmpty()) {
                sb.append("`Roles`.`roleName` = ?, ");
                parameters.add(request.getRoleName());
            }

            if(request.getRoleLevel() > 0) {
                sb.append("`Roles`.`roleLevel` = ?, ");
                parameters.add(request.getRoleLevel());
            }

            if(request.getCompanyID() > 0) {
                sb.append("`Roles`.`companyID` = ?, ");
                parameters.add(request.getCompanyID());
            }

            if(request.getRoleID() == 0) throw new Exception("Không có RoleID");
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Roles`.`roleID` = ?;");
            parameters.add(request.getRoleID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated > 0) {
                return this.readRole(ServerClient.RoleFullInfo.newBuilder()
                                .setRoleID(request.getRoleID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if(resultSet != null) resultSet.close();
            if(preparedStatement != null) preparedStatement.close();
        }
    }

    public Roles registerRole(ServerClient.RoleFullInfo request, Connection connection) throws Exception {
        System.out.println("registerRole");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Roles`(`roleName`, `roleLevel`, `companyID`) VALUES (?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getRoleID() != 0) {
                throw new Exception("Không thêm ID vào");
            }

            String roleName = request.getRoleName();
            if (roleName == null || roleName.isEmpty() || roleName.isEmpty()) {
                roleName = "";
            }

            int roleLevel = request.getRoleLevel();
            if (roleLevel == 0) {
                throw new Exception("Role level không hợp lệ");
            }

            int companyID = request.getCompanyID();
            if (companyID == 0) {
                throw new Exception("Company ID không hợp lệ");
            }

            preparedStatement.setString(1, roleName);
            preparedStatement.setInt(2, roleLevel);
            preparedStatement.setInt(3, companyID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer roleID;
                if (resultSet.next()) {
                    roleID = resultSet.getInt(1);
                    return this.readRole(ServerClient.RoleFullInfo
                                    .newBuilder()
                                    .setRoleID(roleID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm Role thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Boolean deleteRole(ServerClient.RoleFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteRole");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Roles` WHERE `Roles`.`roleID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            if (request.getRoleID() == 0) throw new Exception("Không có RoleID");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getRoleID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
            throw new Exception("RoleID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

}
