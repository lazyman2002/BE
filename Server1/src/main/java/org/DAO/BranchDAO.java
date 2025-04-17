package org.DAO;

import org.model.Branchs;
import org.model.Companies;
import org.model.Locations;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BranchDAO {
    public ArrayList<Branchs> readBranchList(Connection connection) throws Exception {
        System.out.println("readBranchList");

        String query = "SELECT * FROM `Branchs`;";
        ArrayList<Branchs> locationsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer branchID = resultSet.getInt("branchID");
                locationsList.add(
                        this.readBranch(
                                ServerClient.BranchFullInfo.newBuilder()
                                        .setBranchID(branchID)
                                        .build(),
                                connection
                        )
                );
            }

            return locationsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Branchs readBranch(ServerClient.BranchFullInfo request, Connection connection) throws Exception {
        System.out.println("readBranch");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Branchs` WHERE `Branchs`.`branchID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getBranchID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Branchs branch = new Branchs();
                branch.setBranchID(request.getBranchID());
                Integer companyID = resultSet.getInt("companyID");
                branch.setCompanyID(resultSet.wasNull() ? null : companyID);

                String branchName = resultSet.getString("branchName");
                branch.setBranchName(branchName != null ? branchName : "");

                String address = resultSet.getString("address");
                branch.setAddress(address != null ? address : "");

                String contact = resultSet.getString("contact");
                branch.setContact(contact != null ? contact : "");

                String imagePath = resultSet.getString("imagePath");
                branch.setImagePath(imagePath != null ? imagePath : "");
                return branch;
            } else {
                throw new Exception("Branch not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Branchs registerBranch(ServerClient.BranchFullInfo request, Connection connection) throws Exception {
        System.out.println("registerLocation");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Locations`(`companyID`, `branchName`, `address`, `contact`, `imagePath`) VALUES (?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getBranchID() != 0) {
                throw new Exception("Không thêm ID vào");
            }

            int companyID = request.getCompanyID();
            if (companyID == 0) {
                throw new Exception("Company ID không hợp lệ");
            }

            String branchName = request.getBranchName().toString();
            String address = request.getAddress().toString();
            String contact = request.getContact().toString();
            String imagePath = request.getImagePath().toString();

            preparedStatement.setInt(1, companyID);
            preparedStatement.setString(2, branchName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, imagePath);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer locationID;
                if (resultSet.next()) {
                    locationID = resultSet.getInt(1);
                    return this.readBranch(ServerClient.BranchFullInfo
                                    .newBuilder()
                                    .setBranchID(locationID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm Location thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Branchs updateBranch(ServerClient.BranchFullInfo request, Connection connection) throws Exception {
        System.out.println("updateBranch");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Branchs` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (request.getCompanyID() > 0) {
                sb.append("`Branchs`.`companyID` = ?, ");
                parameters.add(request.getCompanyID());
            }

            if (!request.getBranchName().isEmpty()) {
                sb.append("`Branchs`.`branchName` = ?, ");
                parameters.add(request.getBranchName());
            }

            if (!request.getAddress().isEmpty()) {
                sb.append("`Branchs`.`address` = ?, ");
                parameters.add(request.getAddress());
            }

            if (!request.getContact().isEmpty()) {
                sb.append("`Branchs`.`contact` = ?, ");
                parameters.add(request.getContact());
            }

            if (!request.getImagePath().isEmpty()) {
                sb.append("`Branchs`.`imagePath` = ?, ");
                parameters.add(request.getImagePath());
            }

            if (request.getBranchID() == 0) throw new Exception("Không có LocationID");
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Branchs`.`branchID` = ?;");
            parameters.add(request.getBranchID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readBranch(ServerClient.BranchFullInfo.newBuilder()
                                .setBranchID(request.getBranchID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteBranch(ServerClient.BranchFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteBranch");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Branchs` WHERE `Branchs`.`branchID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            if (request.getBranchID() == 0) throw new Exception("No LocationID provided");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getBranchID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }
            throw new Exception("LocationID not found in database");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<Integer> searchBranchInJob(ServerClient.JobRequestRestrict request, Connection connection) throws Exception {
        System.out.println("searchBranchInJob");

        ArrayList<Integer> locationIDs = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        StringBuilder queryBuilder = new StringBuilder("SELECT `Branchs`.`branchID` FROM `Branchs` WHERE 1=1");
        if (!request.getLocation().isEmpty()) {
            queryBuilder.append(" AND CONCAT(branchName, '#', address, '#', contact) LIKE ?");
            parameters.add("%" + request.getLocation() + "%");
        }

        if (request.getCompanyID() != 0) {
            queryBuilder.append(" AND companyID = ?");
            parameters.add(request.getCompanyID());
        }

        if (request.getBranchID() != 0) {
            queryBuilder.append(" AND branchID = ?");
            parameters.add(request.getBranchID());
        }
        try{
            preparedStatement = connection.prepareStatement(queryBuilder.toString());
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                locationIDs.add(resultSet.getInt("branchID"));
            }
            return locationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<Integer> readBranchList(Companies companies, Connection connection) throws Exception {
        System.out.println("readLocationList");

        String query = "SELECT `branchID` FROM `Branchs` WHERE `companyID` = ?;";
        ArrayList<Integer> locationIDs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, companies.getCompaniesID()); // Assuming `Companies` has a `getCompanyID` method
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                locationIDs.add(resultSet.getInt("branchID"));
            }

            return locationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }
}
