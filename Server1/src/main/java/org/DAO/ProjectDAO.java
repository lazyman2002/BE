package org.DAO;

import org.model.Projects;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProjectDAO {
    public Projects readProject(ServerClient.ProjectFullInfo request, Connection connection) throws Exception {
        System.out.println("readProject");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Projects` WHERE `Projects`.`projectID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getProjectID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Projects projects = new Projects();
                projects.setProjectID(request.getProjectID());

                Integer CVID = resultSet.getInt("CVID");
                if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                projects.setCVID(CVID);

                Date startDate = resultSet.getDate("startDate");
                projects.setStartDate(startDate);

                Date endDate = resultSet.getDate("endDate");
                projects.setEndDate(endDate);

                String projectName = resultSet.getString("projectName");
                projectName = (projectName != null) ? projectName : "";
                projects.setProjectName(projectName);

                String PJRole = resultSet.getString("PJRole");
                PJRole = (PJRole != null) ? PJRole : "";
                projects.setPJRole(PJRole);

                String technology = resultSet.getString("technology");
                technology = (technology != null) ? technology : "";
                projects.setTechnology(technology);

                String PJDescription = resultSet.getString("PJDescription");
                PJDescription = (PJDescription != null) ? PJDescription : "";
                projects.setPJDescription(PJDescription);

                return projects;
            } else {
                throw new Exception("Certification not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Projects updateProject(ServerClient.ProjectFullInfo request, Connection connection) throws Exception {
        System.out.println("updateProject");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Projects` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            // Check and append fields for update
            if (!request.getProjectName().isEmpty()) {
                sb.append("`Projects`.`projectName` = ?, ");
                parameters.add(request.getProjectName());
            }

            if (!request.getPJRole().isEmpty()) {
                sb.append("`Projects`.`PJRole` = ?, ");
                parameters.add(request.getPJRole());
            }

            if (!request.getTechnology().isEmpty()) {
                sb.append("`Projects`.`technology` = ?, ");
                parameters.add(request.getTechnology());
            }

            if (!request.getPJDescription().isEmpty()) {
                sb.append("`Projects`.`PJDescription` = ?, ");
                parameters.add(request.getPJDescription());
            }

            if (request.getCVID() != 0) {
                sb.append("`Projects`.`CVID` = ?, ");
                parameters.add(request.getCVID());
            }

            if (request.getProjectID() == 0) throw new Exception("Không có skillID");

            // Remove the last comma and space
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Projects`.`projectID` = ?;");
            parameters.add(request.getProjectID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readProject(ServerClient.ProjectFullInfo
                                .newBuilder()
                                .setProjectID(request.getProjectID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Projects registerProject(ServerClient.ProjectFullInfo request, Connection connection) throws Exception {
        System.out.println("registerSkill");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Projects`(`CVID`, `startDate`, `endDate`, `projectName`, `PJRole`, `technology`, `PJDescription`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }
            if(!request.hasStartDate())     throw new Exception("Start Date");
            if(!request.hasEndDate())     throw new Exception("End Date");

            String projectName = request.getProjectName();
            if (projectName.isEmpty()) {
                throw new Exception("projectName không được để trống");
            }

            String PJRole = request.getPJRole().toString();
            if (PJRole.isEmpty()) {
                throw new Exception("PJRole không được để trống");
            }

            String technology = request.getTechnology().toString();
            if (technology.isEmpty()) {
                throw new Exception("technology không được để trống");
            }

            String PJDescription = request.getPJDescription().toString();
            if (PJDescription.isEmpty()) {
                throw new Exception("PJDescription không được để trống");
            }

            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setDate(2, new Date(request.getStartDate().getSeconds() * 1000));
            preparedStatement.setDate(3, new Date(request.getEndDate().getSeconds() * 1000));
            preparedStatement.setString(4, projectName);
            preparedStatement.setString(5, PJRole);
            preparedStatement.setString(6, technology);
            preparedStatement.setString(7, PJDescription);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer projectID;
                if (resultSet.next()) {
                    projectID = resultSet.getInt(1);
                    return this.readProject(ServerClient.ProjectFullInfo
                                    .newBuilder()
                                    .setProjectID(projectID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm kỹ năng thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Boolean deleteProject(ServerClient.ProjectFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteProject");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Projects` WHERE `Projects`.`projectID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getProjectID() == 0) throw new Exception("Không có skillID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getProjectID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("projectID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<Projects> readProjectList(ServerClient.CVFullInfo request, Connection connection) throws Exception {
        System.out.println("readProjectList");

        String query = "SELECT * FROM `Projects` WHERE `Projects`.`CVID` = ?;";
        ArrayList<Projects> skillsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Projects projects = new Projects();
                projects.setCVID(request.getCVID());

                Integer projectID = resultSet.getInt("projectID");
                if (projectID <= 0) throw new Exception("projectID returned is not valid");
                projects.setProjectID(projectID);

                String projectName = resultSet.getString("projectName");
                projects.setProjectName(projectName != null ? projectName : "");

                String PJRole = resultSet.getString("PJRole");
                projects.setPJRole(PJRole != null ? PJRole : "");

                String technology = resultSet.getString("technology");
                projects.setTechnology(technology != null ? technology : "");

                String PJDescription = resultSet.getString("PJDescription");
                projects.setPJDescription(PJDescription != null ? PJDescription : "");

                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                projects.setStartDate(startDate);
                projects.setEndDate(endDate);

                skillsList.add(projects);
            }
            return skillsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readProjectIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readProjectIDs");

        if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `projectID` FROM `Projects` WHERE `Projects`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> educationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer projectID = resultSet.getInt("projectID");
                if(projectID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                educationIDs.add(projectID);
            }
            return educationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }

}
