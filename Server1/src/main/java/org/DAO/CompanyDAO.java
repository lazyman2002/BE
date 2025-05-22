package org.DAO;

import org.model.Companies;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    public ArrayList<Companies> readCompanyList(Connection connection) throws Exception {
        System.out.println("readCompany");

        String query = "SELECT * FROM `Companies`;";
        ArrayList<Companies> companiesList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer companyID = resultSet.getInt("companyID");
                companiesList.add(this.readCompany(
                        ServerClient.CompanyFullInfo.newBuilder()
                                .setCompaniesID(companyID)
                                .build(),
                        connection
                ));
            }
            return companiesList;
        }finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Companies readCompany(ServerClient.CompanyFullInfo request, Connection connection) throws Exception {
        System.out.println("readCompany");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Companies` WHERE `Companies`.`companyID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql  = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getCompaniesID());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Companies companies = new Companies();
                companies.setCompaniesID(request.getCompaniesID());

                String companyName = resultSet.getString("companyName");
                companyName = (companyName != null) ? companyName : "";
                companies.setCompanyName(companyName);

                String imagePath = resultSet.getString("imagePath");
                imagePath = (imagePath != null) ? imagePath : "";
                companies.setImagePath(imagePath);

                String size = resultSet.getString("size");
                size = (size != null) ? size : "";
                companies.setSize(size);

                String specialty = resultSet.getString("specialty");
                specialty = (specialty != null) ? specialty : "";
                companies.setSpecialty(specialty);

                String introduction = resultSet.getString("introduction");
                introduction = (introduction != null) ? introduction : "";
                companies.setIntroduction(introduction);

                String address = resultSet.getString("address");
                address = (address != null) ? address : "";
                companies.setAddress(address);

                String website = resultSet.getString("website");
                website = (website != null) ? website : "";
                companies.setWebsite(website);

                String email = resultSet.getString("email");
                email = (email != null) ? email : "";
                companies.setEmail(email);

                Boolean validated = resultSet.getBoolean("validated");
                companies.setValidated(validated);

                return companies;
            }
            else throw new Exception("Không tìm được công ty");
        }
        finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Companies registerCompany(ServerClient.CompanyFullInfo request, Connection connection) throws Exception{
        System.out.println("registerCompany");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Companies`(`companyName`, `imagePath`, `specialty`, `size`, `introduction`, `address`, `website`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCompaniesID() != 0) {
                throw new Exception("Không thêm ID vào");
            }

            String companyName = request.getCompanyName();
            if (companyName.isEmpty()) companyName = "";

            String imagePath = request.getImagePath();
            if (imagePath.isEmpty()) imagePath = "";

            String specialty = request.getSpecialty();
            if (specialty.isEmpty()) specialty = "";

            String size = request.getSize();
            if (size.isEmpty()) size = "";

            String introduction = request.getIntroduction();
            if (introduction.isEmpty()) introduction = "";

            String address = request.getAddress();
            if (address.isEmpty()) address = "";

            String website = request.getWebsite();
            if (website.isEmpty()) website = "";

            String email = request.getEmail();
            if (email.isEmpty()) email = "";


            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, imagePath);
            preparedStatement.setString(3, specialty);
            preparedStatement.setString(4, size);
            preparedStatement.setString(5, introduction);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, website);
            preparedStatement.setString(8, email);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer companyID;
                if (resultSet.next()) {
                    companyID = resultSet.getInt(1);
                    return this.readCompany(ServerClient.CompanyFullInfo
                                    .newBuilder()
                                    .setCompaniesID(companyID)
                                    .build(),
                            connection);
                }
            }
            else throw new Exception("Không thêm CT thành công");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Companies updateCompany(ServerClient.CompanyFullInfo request, Connection connection) throws Exception{
        System.out.println("updateCompany");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Companies` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try{
            if(!request.getCompanyName().isEmpty()){
                sb.append("`Companies`.`companyName` = ?, ");
                parameters.add(request.getCompanyName());
            }

            if(!request.getImagePath().isEmpty()){
                sb.append("`Companies`.`imagePath` = ?, ");
                parameters.add(request.getImagePath());
            }

            if(!request.getSpecialty().isEmpty()){
                sb.append("`Companies`.`specialty` = ?, ");
                parameters.add(request.getSpecialty());
            }

            if(!request.getSize().isEmpty()){
                sb.append("`Companies`.`size` = ?, ");
                parameters.add(request.getSize());
            }

            if(!request.getIntroduction().isEmpty()){
                sb.append("`Companies`.`introduction` = ?, ");
                parameters.add(request.getIntroduction());
            }

            if(!request.getAddress().isEmpty()){
                sb.append("`Companies`.`address` = ?, ");
                parameters.add(request.getAddress());
            }

            if(!request.getWebsite().isEmpty()){
                sb.append("`Companies`.`website` = ?, ");
                parameters.add(request.getWebsite());
            }

            if(!request.getEmail().isEmpty()){
                sb.append("`Companies`.`email` = ?, ");
                parameters.add(request.getEmail());
            }

            sb.append("`Companies`.`validated` = ?, ");
            parameters.add(request.getValidated());

            if(request.getCompaniesID() == 0)    throw new Exception("Không có CompanyID");
            sb.setLength(sb.length()-2);
            sb.append(" WHERE `Companies`.`companyID` = ?;");
            parameters.add(request.getCompaniesID());

            String sql =sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated >0 ){
                return this.readCompany(ServerClient.CompanyFullInfo.newBuilder()
                                .setCompaniesID(request.getCompaniesID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Boolean deleteCompany(ServerClient.CompanyFullInfo request,Connection connection) throws Exception{
        System.out.println("deleteCompany");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Companies` WHERE `Companies`.`companyID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            if(request.getCompaniesID() == 0) throw new Exception("Không có CompanyID");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getCompaniesID());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                return true;
            }
            throw new Exception("CompanyID không có trong CSDL");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }
}
