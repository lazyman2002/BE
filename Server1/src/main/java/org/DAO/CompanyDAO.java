package org.DAO;

import org.controller.Converter;
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
                Companies company = new Companies();

                Integer companyID = resultSet.getInt("companyID");
                if (resultSet.wasNull()) {
                    company.setCompaniesID(null);
                } else {
                    company.setCompaniesID(companyID);
                }

                String companyName = resultSet.getString("companyName");
                company.setCompanyName(companyName != null ? companyName : "");

                String companyAvatarURL = resultSet.getString("companyAvatarURL");
                company.setCompanyAvatarURL(companyAvatarURL != null ? companyAvatarURL : "");

                String website = resultSet.getString("website");
                company.setWebsite(website != null ? website : "");

                String email = resultSet.getString("email");
                company.setEmail(email != null ? email : "");

                companiesList.add(company);
            }
            return companiesList;
        }finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Companies readCompany(ServerClient.CompanyMetaInfo request, Connection connection) throws Exception {
        System.out.println("readCompany");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Companies` WHERE `Companies`.`companyID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql  = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getCompanyID());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String companyName = resultSet.getString("companyName");
                companyName = (companyName != null) ? companyName : ""; // Gán giá trị mặc định nếu null

                String companyAvatarURL = resultSet.getString("companyAvatarURL");
                companyAvatarURL = (companyAvatarURL != null) ? companyAvatarURL : ""; // Giá trị mặc định

                String website = resultSet.getString("website");
                website = (website != null) ? website : "";

                String email = resultSet.getString("email");
                email = (email != null) ? email : "";

                return new Companies(
                        request.getCompanyID(),
                        companyName, companyAvatarURL, website, email
                );
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
        sb.append("INSERT INTO `Companies`(`companyName`, `companyAvatarURL`, `website`, `email`) VALUES (?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCompaniesID() != 0) {
                throw new Exception("Không thêm ID vào");
            }

            String companyName = request.getCompanyName();
            if (companyName == null || companyName.isEmpty() || companyName.isBlank()) {
                companyName = "";
            }

            String companyAvatarURL = request.getCompanyAvatarURL();
            if (companyAvatarURL == null || companyAvatarURL.isEmpty() || companyAvatarURL.isBlank()) {
                companyAvatarURL = "";
            }

            String website = request.getWebsite();
            if (website == null || website.isEmpty() || website.isBlank()) {
                website = "";
            }

            String email = request.getEmail();
            if (email == null || email.isEmpty() || email.isBlank()) {
                email = "";
            }

            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, companyAvatarURL);
            preparedStatement.setString(3, website);
            preparedStatement.setString(4, email);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer companyID;
                if (resultSet.next()) {
                    companyID = resultSet.getInt(1);
                    CompanyDAO companyDAO = new CompanyDAO();
                    return companyDAO.readCompany(ServerClient.CompanyMetaInfo
                                    .newBuilder()
                                    .setCompanyID(companyID)
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
            if(request.getCompanyName() != null && !request.getCompanyName().isBlank() && !request.getCompanyName().isEmpty()){
                sb.append("`Companies`.`companyName` = ?, ");
                parameters.add(request.getCompanyName());
            }

            if(request.getCompanyAvatarURL() != null && !request.getCompanyAvatarURL().isBlank() && !request.getCompanyAvatarURL().isEmpty()){
                sb.append("`Companies`.`companyAvatarURL` = ?, ");
                parameters.add(request.getCompanyAvatarURL());
            }

            if(request.getWebsite() != null && !request.getWebsite().isBlank() && !request.getWebsite().isEmpty()){
                sb.append("`Companies`.`website` = ?, ");
                parameters.add(request.getWebsite());
            }

            if(request.getEmail() != null && !request.getEmail().isBlank() && !request.getEmail().isEmpty()){
                sb.append("`Companies`.`email` = ?, ");
                parameters.add(request.getEmail());
            }

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
                return this.readCompany(ServerClient.CompanyMetaInfo.newBuilder()
                                .setCompanyID(request.getCompaniesID())
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

    public Boolean deleteCompany(ServerClient.CompanyMetaInfo request,Connection connection) throws Exception{
        System.out.println("deleteCompany");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Companies` WHERE `Companies`.`companyID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            if(request.getCompanyID() == 0) throw new Exception("Không có CompanyID");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getCompanyID());

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
