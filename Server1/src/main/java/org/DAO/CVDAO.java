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
    public ArrayList<CVs> readCVList(ServerClient.UserFullInfo request, Connection connection) throws Exception {
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
                Integer cvID = resultSet.getInt("CVID");
                CVs cv = this.readCV(ServerClient.CVFullInfo.newBuilder().setCVID(cvID).build(), connection);
                cvList.add(cv);
            }
            return cvList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public CVs readCV(ServerClient.CVFullInfo request, Connection connection) throws Exception {
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
                CVs cVs = new CVs();
                int cvID = resultSet.getInt("CVID");
                cVs.setCVID(cvID);

                int userID = resultSet.getInt("candidateID");
                if (userID == 0) throw new Exception("CV has an invalid userID");
                cVs.setCandidatesID(userID);

                String CVname = resultSet.getString("CVname");
                CVname = (CVname != null) ? CVname : "";
                cVs.setCVname(CVname);

                String imagePath = resultSet.getString("imagePath");
                imagePath = (imagePath != null) ? imagePath : "";
                cVs.setImagePath(imagePath);

                String jobPositions = resultSet.getString("jobPositions");
                jobPositions = (jobPositions != null) ? jobPositions : "";
                cVs.setJobPositions(jobPositions);

                String introduce = resultSet.getString("introduce");
                introduce = (introduce != null) ? introduce : "";
                cVs.setIntroduce(introduce);

                String email = resultSet.getString("email");
                email = (email != null) ? email : "";
                cVs.setEmail(email);

                String phoneNumber = resultSet.getString("phoneNumber");
                phoneNumber = (phoneNumber != null) ? phoneNumber : "";
                cVs.setPhoneNumber(phoneNumber);

                String socialMedia = resultSet.getString("socialMedia");
                socialMedia = (socialMedia != null) ? socialMedia : "";
                cVs.setSocialMedia(socialMedia);
                return cVs;
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
            if (request.getCandidateID() !=0 ) {
                sb.append("`CVs`.`candidateID` = ?, ");
                parameters.add(request.getCandidateID());
            }

            if (!request.getCVname().isEmpty()) {
                sb.append("`CVs`.`CVname` = ?, ");
                parameters.add(request.getCVname());
            }


            if (!request.getImagePath().isEmpty()) {
                sb.append("`CVs`.`imagePath` = ?, ");
                parameters.add(request.getImagePath());
            }

            if (!request.getJobPositions().isEmpty()) {
                sb.append("`CVs`.`jobPositions` = ?, ");
                parameters.add(request.getJobPositions());
            }

            if (!request.getIntroduce().isEmpty()) {
                sb.append("`CVs`.`introduce` = ?, ");
                parameters.add(request.getIntroduce());
            }

            if (!request.getEmail().isEmpty()) {
                sb.append("`CVs`.`email` = ?, ");
                parameters.add(request.getEmail());
            }

            if (!request.getPhoneNumber().isEmpty()) {
                sb.append("`CVs`.`phoneNumber` = ?, ");
                parameters.add(request.getPhoneNumber());
            }

            if (!request.getSocialMedia().isEmpty()) {
                sb.append("`CVs`.`socialMedia` = ?, ");
                parameters.add(request.getSocialMedia());
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
                return this.readCV(ServerClient.CVFullInfo.newBuilder()
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
        sb.append("INSERT INTO `CVs`(`candidateID`, `CVname`, `imagePath`, `jobPositions`, `introduce`, `email`, `phoneNumber`, `socialMedia`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
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

            String CVname = request.getCVname();
            if (CVname.isEmpty()) {
                throw new Exception("CV name không hợp lệ");
            }

            String imagePath = request.getImagePath();
            if (imagePath.isEmpty()) {
                imagePath = null; // Allow NULL if image path is not provided
            }

            String jobPositions = request.getJobPositions();
            if (jobPositions.isEmpty()) {
                jobPositions = null; // Allow NULL if job positions are not provided
            }

            String introduce = request.getIntroduce();
            if (introduce.isEmpty()) {
                introduce = null; // Allow NULL if introduction is not provided
            }

            String email = request.getEmail();
            if (email.isEmpty()) {
                email = null; // Allow NULL if email is not provided
            }

            String phoneNumber = request.getPhoneNumber();
            if (phoneNumber.isEmpty()) {
                phoneNumber = null; // Allow NULL if phone number is not provided
            }

            String socialMedia = request.getSocialMedia();
            if (socialMedia.isEmpty()) {
                socialMedia = null; // Allow NULL if social media is not provided
            }

            preparedStatement.setInt(1, candidateID);
            preparedStatement.setString(2, CVname);
            preparedStatement.setString(3, imagePath);
            preparedStatement.setString(4, jobPositions);
            preparedStatement.setString(5, introduce);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, phoneNumber);
            preparedStatement.setString(8, socialMedia);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer cvid;
                if (resultSet.next()) {
                    cvid = resultSet.getInt(1);
                    return this.readCV(ServerClient.CVFullInfo
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

    public Boolean deleteCV(ServerClient.CVFullInfo request, Connection connection) throws Exception {
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

    public Boolean applyCV(ServerClient.AppliesInfo request, Connection connection) throws Exception {
        System.out.println("applyCV");

        String sql = "UPDATE `Applies` SET `status` = ? WHERE `CVID` = ? AND `jobID` = ?;";
        PreparedStatement preparedStatement = null;

        try {
            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }
            if (request.getJobID() == 0) {
                throw new Exception("JobID không hợp lệ");
            }

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getStatus().name());  // Cập nhật status
            preparedStatement.setInt(2, request.getCVID());
            preparedStatement.setInt(3, request.getJobID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                throw new Exception("Không cập nhật được trạng thái CV");
            }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean applyStatus(ServerClient.AppliesInfo request, Connection connection) throws Exception {
        System.out.println("applyStatus");

        String sql = "SELECT 1 FROM `Applies` WHERE `CVID` = ? AND `jobID` = ? LIMIT 1;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }
            if (request.getJobID() == 0) {
                throw new Exception("JobID không hợp lệ");
            }

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setInt(2, request.getJobID());

            resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // true nếu tìm thấy dòng phù hợp, ngược lại false
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

}