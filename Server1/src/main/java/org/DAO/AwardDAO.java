package org.DAO;

import org.model.Awards;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AwardDAO {
    public ArrayList<Awards> readAwardList(ServerClient.CVFullInfo request, Connection connection) throws Exception {
        System.out.println("readAwardList");

        String query = "SELECT * FROM Awards WHERE Awards.CVID = ?;";
        ArrayList<Awards> awardsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Awards awards = new Awards();
                awards.setCVID(request.getCVID());

                Integer awardID = resultSet.getInt("awardID");
                if (awardID <= 0) throw new Exception("AwardID trả về không hợp lệ");
                awards.setAwardID(awardID);

                String awardName = resultSet.getString("awardName");
                awards.setAwardName(awardName != null ? awardName : "");

                Date provideDate = resultSet.getDate("provideDate");
                awards.setProvideDate(provideDate);

                awardsList.add(awards);
            }
            return awardsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Awards readAward(ServerClient.AwardFullInfo request, Connection connection) throws Exception {
        System.out.println("readAward");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Awards` WHERE `Awards`.`awardID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getAwardID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Awards awards = new Awards();
                awards.setAwardID(request.getAwardID());

                Integer CVID = resultSet.getInt("CVID");
                if (CVID <= 0) throw new Exception("Kết quả trả về không hợp lệ");
                awards.setCVID(CVID);

                String awardName = resultSet.getString("awardName");
                awardName = (awardName != null) ? awardName : "";
                awards.setAwardName(awardName);

                Date provideDate = resultSet.getDate("provideDate");
                awards.setProvideDate(provideDate);

                return awards;
            } else {
                throw new Exception("Award not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Awards registerAward(ServerClient.AwardFullInfo request, Connection connection) throws Exception {
        System.out.println("registerAward");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Awards`(`CVID`, `awardName`, `provideDate`) VALUES (?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Kiểm tra CVID
            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }

            // Kiểm tra awardName
            String awardName = request.getAwardName();
            if (awardName == null || awardName.isEmpty()) {
                throw new Exception("Tên giải thưởng không được để trống");
            }

            // Kiểm tra awardedDate
            com.google.protobuf.Timestamp timestamp = request.getProvideDate();
            if (!request.hasProvideDate()) {
                throw new Exception("Ngày nhận giải thưởng không hợp lệ");
            }
            Date awardedDate = new Date(timestamp.getSeconds() * 1000);

            // Gán các giá trị vào preparedStatement
            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setString(2, awardName);
            preparedStatement.setDate(3, awardedDate);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer awardID;
                if (resultSet.next()) {
                    awardID = resultSet.getInt(1);
                    return this.readAward(ServerClient.AwardFullInfo
                                    .newBuilder()
                                    .setAwardID(awardID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm giải thưởng thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Awards updateAward(ServerClient.AwardFullInfo request, Connection connection) throws Exception {
        System.out.println("updateAward");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Awards` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            // Xử lý awardName
            if (request.getAwardName() != null && !request.getAwardName().isEmpty()) {
                sb.append("`Awards`.`awardName` = ?, ");
                parameters.add(request.getAwardName());
            }

            // Xử lý awardedDate
            if (request.hasProvideDate()) {
                Date awardedDate = new Date(request.getProvideDate().getSeconds() * 1000);
                sb.append("`Awards`.`provideDate` = ?, ");
                parameters.add(awardedDate);
            }

            // Xử lý CVID
            if (request.getCVID() != 0) {
                sb.append("`Awards`.`CVID` = ?, ");
                parameters.add(request.getCVID());
            }

            // Kiểm tra awardID
            if (request.getAwardID() == 0) throw new Exception("Không có awardID");

            // Loại bỏ dấu phẩy cuối cùng và thêm điều kiện WHERE
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Awards`.`awardID` = ?;");
            parameters.add(request.getAwardID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            // Gán giá trị cho các tham số trong preparedStatement
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            // Thực thi câu lệnh cập nhật
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readAward(ServerClient.AwardFullInfo.newBuilder()
                                .setAwardID(request.getAwardID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteAward(ServerClient.AwardFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteAward");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Awards` WHERE `Awards`.`awardID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Kiểm tra awardID
            if (request.getAwardID() == 0) throw new Exception("Không có awardID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getAwardID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("awardID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readAwardIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readAwardIDs");

        if (CVID <= 0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `awardID` FROM `Awards` WHERE `Awards`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> awardIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer awardID = resultSet.getInt("awardID");
                if (awardID <= 0) throw new Exception("Kết quả trả về không hợp lệ");
                awardIDs.add(awardID);
            }
            return awardIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

}
