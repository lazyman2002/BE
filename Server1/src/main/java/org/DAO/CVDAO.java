package org.DAO;

import org.model.CVs;
import org.model.Candidates;
import org.model.JobRequests;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CVDAO {
    public ArrayList<CVs> readCVList(ServerClient.UserMetaInfo request, Connection connection) throws Exception {
        System.out.println("readCVList");

        String query = "SELECT * FROM `CVs` WHERE `CVs`.`candidateID` = ?;";
        ArrayList<CVs> cvList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getUserID() == 0) throw new Exception("candidateID is missing");
            preparedStatement.setInt(1, request.getUserID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CVs cv = new CVs();
                cv.setCandidatesID(request.getUserID());

                Integer cvID = resultSet.getInt("CVID");
                if (resultSet.wasNull()) {
                    cv.setCVID(null);
                } else {
                    cv.setCVID(cvID);
                }

                String jobTitle = resultSet.getString("jobTitle");
                cv.setJobTitle(jobTitle != null ? jobTitle : "");

                String email = resultSet.getString("email");
                cv.setEmail(email != null ? email : "");

                String phoneNumber = resultSet.getString("phoneNumber");
                cv.setPhoneNumber(phoneNumber != null ? phoneNumber : "");
                cvList.add(cv);
            }
            return cvList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public CVs readCV(ServerClient.CVMetaInfo request, Connection connection) throws Exception {
        System.out.println("readCV");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `CVs` WHERE `CVs`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cvID = resultSet.getInt("CVID");
                int userID = resultSet.getInt("candidateID");
                if (userID == 0) throw new Exception("CV has an invalid userID");
                String email = resultSet.getString("email");
                email = (email != null) ? email : "";
                String phoneNumber = resultSet.getString("phoneNumber");
                phoneNumber = (phoneNumber != null) ? phoneNumber : "";
                String jobTitle = resultSet.getString("jobTitle");
                String imagePath = resultSet.getString("imagePath");
                String CVname = resultSet.getString("CVname");

                jobTitle = (jobTitle != null) ? jobTitle : "";

                return new CVs(
                        cvID,
                        userID,
                        email,
                        phoneNumber,
                        jobTitle, imagePath, CVname
                );
            } else {
                throw new Exception("CV not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public CVs updateCV(ServerClient.CVFullInfo request, Connection connection) throws Exception {
        System.out.println("updateCV");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `CVs` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
                sb.append("`CVs`.`email` = ?, ");
                parameters.add(request.getEmail());
            }

            if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
                sb.append("`CVs`.`phoneNumber` = ?, ");
                parameters.add(request.getPhoneNumber());
            }

            if (request.getJobTitle() != null && !request.getJobTitle().isEmpty()) {
                sb.append("`CVs`.`jobTitle` = ?, ");
                parameters.add(request.getJobTitle());
            }

            if (request.getCandidateID() > 0) {
                sb.append("`CVs`.`candidateID` = ?, ");
                parameters.add(request.getCandidateID());
            }

            if (request.getCVID() == 0) throw new Exception("Không có CVID");
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
            sb.append(" WHERE `CVs`.`CVID` = ?;");
            parameters.add(request.getCVID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readCV(ServerClient.CVMetaInfo.newBuilder()
                                .setCVID(request.getCVID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public CVs registerCV(ServerClient.CVFullInfo request, Connection connection) throws Exception {
        System.out.println("registerCV");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `CVs`(`candidateID`, `email`, `phoneNumber`, `jobTitle`) VALUES (?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() != 0) {
                throw new Exception("Không thêm ID vào");
            }

            int candidateID = request.getCandidateID();
            if (candidateID == 0) {
                throw new Exception("Candidate ID không hợp lệ");
            }

            String email = request.getEmail();
            if (email == null || email.isEmpty() || email.isEmpty()) {
                email = null; // Allow NULL if email is not provided
            }

            String phoneNumber = request.getPhoneNumber();
            if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.isEmpty()) {
                phoneNumber = null; // Allow NULL if phone number is not provided
            }

            String jobTitle = request.getJobTitle();
            if (jobTitle == null || jobTitle.isEmpty() || jobTitle.isEmpty()) {
                throw new Exception("Job title không hợp lệ");
            }

            preparedStatement.setInt(1, candidateID);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, jobTitle);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer cvid;
                if (resultSet.next()) {
                    cvid = resultSet.getInt(1);
                    return this.readCV(ServerClient.CVMetaInfo
                                    .newBuilder()
                                    .setCVID(cvid)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm CV thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Boolean deleteCV(ServerClient.CVMetaInfo request, Connection connection) throws Exception {
        System.out.println("deleteCV");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `CVs` WHERE `CVs`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        try {
            String sql = sb.toString();
            if (request.getCVID() == 0) throw new Exception("Không có CVID");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getCVID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
            throw new Exception("CVID không có trong CSDL");
        } finally {
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readCVIDs(Candidates candidates, Connection connection) throws Exception {
        System.out.println("readCVIDs");

        Integer candidateID = candidates.getUserID();
        if(candidateID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `CVID` FROM `CVs` WHERE `CVs`.`candidateID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> certificationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, candidateID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer certificationID = resultSet.getInt("CVID");
                if(certificationID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                certificationIDs.add(certificationID);
            }
            return certificationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }

    public HashSet<Integer> readCVIDs(JobRequests jobRequests, Connection connection) throws Exception {
        System.out.println("readCVIDs");

        Integer jobID = jobRequests.getJobID();
        if(jobID <=0) throw new Exception("Kết quả trả về không hợp lệ");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `CVID` FROM `Applies` WHERE `Applies`.`jobID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> certificationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, jobID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer CVID = resultSet.getInt("CVID");
                if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                certificationIDs.add(CVID);
            }
            return certificationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }
}