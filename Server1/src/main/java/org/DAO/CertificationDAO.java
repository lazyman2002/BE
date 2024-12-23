package org.DAO;

import org.model.Certifications;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CertificationDAO {
    public ArrayList<Certifications> readCertificationList(ServerClient.CVMetaInfo request, Connection connection) throws Exception {
        System.out.println("readCertificationList");

        String query = "SELECT * FROM `Certifications` WHERE `Certifications`.`CVID` = ?;";
        ArrayList<Certifications> certificationsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Certifications certifications = new Certifications();
                certifications.setCVID(request.getCVID());

                Integer certificationID = resultSet.getInt("certificationID");
                if(certificationID <= 0) throw new Exception("CertificationID trả về không hợp lệ");
                certifications.setCertificationID(certificationID);

                String certificationName = resultSet.getString("certificationName");
                certifications.setCertificationName(certificationName != null ? certificationName : "");

                String provider = resultSet.getString("provider");
                certifications.setProvider(provider != null ? provider : "");

                Date providedDate = resultSet.getDate("providedDate");
                certifications.setProvidedDate(providedDate);

                certificationsList.add(certifications);
            }
            return certificationsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Certifications readCertification(ServerClient.CertificationFullInfo request, Connection connection) throws Exception {
        System.out.println("readCertification");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Certifications` WHERE `Certifications`.`certificationID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getCertificationID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Integer CVID = resultSet.getInt("CVID");
                if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");

                String certificationName = resultSet.getString("certificationName");
                certificationName = (certificationName != null) ? certificationName : "";

                String provider = resultSet.getString("provider");
                provider = (provider != null) ? provider : "";

                Date providedDate = resultSet.getDate("providedDate");

                return new Certifications(
                        CVID,
                        certificationName,
                        provider,
                        providedDate,
                        request.getCertificationID()
                );
            } else {
                throw new Exception("Certification not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Certifications registerCertification(ServerClient.CertificationFullInfo request, Connection connection) throws Exception {
        System.out.println("registerCertification");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Certifications`(`CVID`, `certificationName`, `provider`, `providedDate`) VALUES (?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }

            String certificationName = request.getCertificationName();
            if (certificationName == null || certificationName.isEmpty()) {
                throw new Exception("Tên chứng chỉ không được để trống");
            }

            String provider = request.getProvider();
            if (provider == null || provider.isEmpty()) {
                throw new Exception("Provider không được để trống");
            }

            com.google.protobuf.Timestamp timestamp = request.getProvidedDate();
            if (!request.hasProvidedDate()) {
                throw new Exception("Ngày cấp chứng chỉ không hợp lệ");
            }
            java.sql.Date providedDate = new java.sql.Date(timestamp.getSeconds() * 1000);

            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setString(2, certificationName);
            preparedStatement.setString(3, provider);
            preparedStatement.setDate(4, providedDate);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer certificationID;
                if (resultSet.next()) {
                    certificationID = resultSet.getInt(1);
                    return this.readCertification(ServerClient.CertificationFullInfo
                                    .newBuilder()
                                    .setCertificationID(certificationID)
                                    .build(),
                            connection);
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

    public Certifications updateCertification(ServerClient.CertificationFullInfo request, Connection connection) throws Exception {
        System.out.println("updateCertification");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Certifications` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            // Check and append fields for update
            if (request.getCertificationName() != null && !request.getCertificationName().isEmpty()) {
                sb.append("`Certifications`.`certificationName` = ?, ");
                parameters.add(request.getCertificationName());
            }

            if (request.getProvider() != null && !request.getProvider().isEmpty()) {
                sb.append("`Certifications`.`provider` = ?, ");
                parameters.add(request.getProvider());
            }

            if (request.hasProvidedDate()) {
                java.sql.Date providedDate = new java.sql.Date(request.getProvidedDate().getSeconds() * 1000);
                sb.append("`Certifications`.`providedDate` = ?, ");
                parameters.add(providedDate);
            }

            if(request.getCVID() !=0){
                sb.append("`Certifications`.`CVID` = ?, ");
                parameters.add(request.getCVID());
            }

            if (request.getCertificationID() == 0) throw new Exception("Không có certificationID");

            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Certifications`.`certificationID` = ?;");
            parameters.add(request.getCertificationID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readCertification(ServerClient.CertificationFullInfo.newBuilder()
                                .setCertificationID(request.getCertificationID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteCertification(ServerClient.CertificationFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteCertification");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Certifications` WHERE `Certifications`.`certificationID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getCertificationID() == 0) throw new Exception("Không có cerID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getCertificationID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("cerID không có trong CSDL");
        }
        finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readCertificationIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readCertificationID");

        if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `certificationID` FROM `Certifications` WHERE `Certifications`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> certificationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer certificationID = resultSet.getInt("certificationID");
                if(certificationID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                certificationIDs.add(certificationID);
            }
            return certificationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }
}
