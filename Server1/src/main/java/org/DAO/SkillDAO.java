package org.DAO;

import org.model.Proficiency;
import org.model.Skills;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SkillDAO {
    public ArrayList<Skills> readSkillsList(ServerClient.CVMetaInfo request, Connection connection) throws Exception {
        System.out.println("readSkillsList");

        String query = "SELECT * FROM `Skills` WHERE `Skills`.`CVID` = ?;";
        ArrayList<Skills> skillsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Skills skills = new Skills();
                skills.setCVID(request.getCVID());

                Integer skillID = resultSet.getInt("skillID");
                if (skillID <= 0) throw new Exception("SkillID returned is not valid");
                skills.setSkillID(skillID);

                String skillName = resultSet.getString("skillName");
                skills.setSkillName(skillName != null ? skillName : "");

                String proficiency = resultSet.getString("proficiency");
                if (proficiency != null) {
                    try {
                        Proficiency proficiencyEnum = Proficiency.valueOf(proficiency.toUpperCase());
                        skills.setProficiency(proficiencyEnum);
                    } catch (IllegalArgumentException e) {
                        throw new Exception("Invalid proficiency value returned");
                    }
                } else {
                    skills.setProficiency(Proficiency.BEGINNER);
                }

                skillsList.add(skills);
            }
            return skillsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Skills readSkill(ServerClient.SkillFullInfo request, Connection connection) throws Exception {
        System.out.println("readSkill");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Skills` WHERE `Skills`.`skillID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getSkillID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Integer CVID = resultSet.getInt("CVID");
                if (CVID <= 0) throw new Exception("Invalid result: CVID returned is not valid");

                String skillName = resultSet.getString("skillName");
                skillName = (skillName != null) ? skillName : "";

                String proficiencyStr = resultSet.getString("proficiency");
                Proficiency proficiency = Proficiency.BEGINNER; // Set a default value
                if (proficiencyStr != null) {
                    try {
                        proficiency = Proficiency.valueOf(proficiencyStr.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new Exception("Invalid proficiency value returned");
                    }
                }

                return new Skills(
                        CVID,
                        skillName,
                        proficiency,
                        request.getSkillID()
                );
            } else {
                throw new Exception("Skill not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Skills registerSkill(ServerClient.SkillFullInfo request, Connection connection) throws Exception {
        System.out.println("registerSkill");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Skills`(`CVID`, `skillName`, `proficiency`) VALUES (?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }

            String skillName = request.getSkillName();
            if (skillName == null || skillName.isEmpty() || skillName.isEmpty()) {
                throw new Exception("Tên kỹ năng không được để trống");
            }

            String proficiencyStr = request.getProficiency().toString();
            if (proficiencyStr == null || proficiencyStr.isEmpty() || proficiencyStr.isEmpty()) {
                throw new Exception("Proficiency không được để trống");
            }

            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setString(2, skillName);
            preparedStatement.setString(3, proficiencyStr);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer skillID;
                if (resultSet.next()) {
                    skillID = resultSet.getInt(1);
                    return this.readSkill(ServerClient.SkillFullInfo
                                    .newBuilder()
                                    .setSkillID(skillID)
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

    public Skills updateSkill(ServerClient.SkillFullInfo request, Connection connection) throws Exception {
        System.out.println("updateSkill");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Skills` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            // Check and append fields for update
            if (request.getSkillName() != null && !request.getSkillName().isEmpty() && !request.getSkillName().isEmpty()) {
                sb.append("`Skills`.`skillName` = ?, ");
                parameters.add(request.getSkillName());
            }

            if (request.getProficiency() != null) {
                sb.append("`Skills`.`proficiency` = ?, ");
                parameters.add(request.getProficiency().toString());
            }

            if (request.getCVID() != 0) {
                sb.append("`Skills`.`CVID` = ?, ");
                parameters.add(request.getCVID());
            }

            if (request.getSkillID() == 0) throw new Exception("Không có skillID");

            // Remove the last comma and space
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Skills`.`skillID` = ?;");
            parameters.add(request.getSkillID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readSkill(ServerClient.SkillFullInfo.newBuilder()
                                .setSkillID(request.getSkillID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteSkill(ServerClient.SkillFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteSkill");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Skills` WHERE `Skills`.`skillID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getSkillID() == 0) throw new Exception("Không có skillID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getSkillID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("skillID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readSkillIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readSkillIDs");

        if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `skillID` FROM `Skills` WHERE `Skills`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> educationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer educationID = resultSet.getInt("skillID");
                if(educationID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                educationIDs.add(educationID);
            }
            return educationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }
}