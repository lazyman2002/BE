package org.DAO;

import org.model.Locations;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
    public ArrayList<Locations> readLocationList(Connection connection) throws Exception {
        System.out.println("readLocationList");

        String query = "SELECT * FROM `Locations`;";
        ArrayList<Locations> locationsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Locations location = new Locations();
                Integer companyID = resultSet.getInt("companyID");
                location.setCompanyID(resultSet.wasNull() ? null : companyID);

                Integer locationID = resultSet.getInt("locationID");
                location.setLocationID(resultSet.wasNull() ? null : locationID);

                String city = resultSet.getString("city");
                location.setCity(city != null ? city : "");

                String state = resultSet.getString("state");
                location.setState(state != null ? state : "");

                String country = resultSet.getString("country");
                location.setCountry(country != null ? country : "");

                String address = resultSet.getString("address");
                location.setAddress(address != null ? address : "");

                String contact = resultSet.getString("contact");
                location.setContactNumber(contact != null ? contact : "");

                locationsList.add(location);
            }

            return locationsList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Locations readLocation(ServerClient.LocationMetaInfo request, Connection connection) throws Exception {
        System.out.println("readLocation");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Locations` WHERE `Locations`.`locationID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getLocationID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Locations location = new Locations();
                Integer companyID = resultSet.getInt("companyID");
                location.setCompanyID(resultSet.wasNull() ? null : companyID);

                Integer locationID = resultSet.getInt("locationID");
                location.setLocationID(resultSet.wasNull() ? null : locationID);

                String city = resultSet.getString("city");
                location.setCity(city != null ? city : "");

                String state = resultSet.getString("state");
                location.setState(state != null ? state : "");

                String country = resultSet.getString("country");
                location.setCountry(country != null ? country : "");

                String address = resultSet.getString("address");
                location.setAddress(address != null ? address : "");

                String contact = resultSet.getString("contact");
                location.setContactNumber(contact != null ? contact : "");
                return location;
            } else {
                throw new Exception("Location not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Locations registerLocation(ServerClient.LocationFullInfo request, Connection connection) throws Exception {
        System.out.println("registerLocation");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Locations`(`companyID`, `city`, `state`, `country`, `address`, `contact`) VALUES (?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getLocationID() != 0) {
                throw new Exception("Không thêm ID vào");
            }

            int companyID = request.getCompanyID();
            if (companyID == 0) {
                throw new Exception("Company ID không hợp lệ");
            }

            String city = request.getCity();
            if (city == null || city.isEmpty() || city.isBlank()) {
                city = "";
            }

            String state = request.getState();
            if (state == null || state.isEmpty() || state.isBlank()) {
                state = "";
            }

            String country = request.getCountry();
            if (country == null || country.isEmpty() || country.isBlank()) {
                country = "";
            }

            String address = request.getAddress();
            if (address == null || address.isEmpty() || address.isBlank()) {
                address = "";
            }

            String contact = request.getContactNumber();
            if (contact == null || contact.isEmpty() || contact.isBlank()) {
                contact = "";
            }

            preparedStatement.setInt(1, companyID);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, state);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, contact);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer locationID;
                if (resultSet.next()) {
                    locationID = resultSet.getInt(1);
                    return this.readLocation(ServerClient.LocationMetaInfo
                                    .newBuilder()
                                    .setLocationID(locationID)
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

    public Locations updateLocation(ServerClient.LocationFullInfo request, Connection connection) throws Exception {
        System.out.println("updateLocation");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Locations` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (request.getCompanyID() > 0) {
                sb.append("`Locations`.`companyID` = ?, ");
                parameters.add(request.getCompanyID());
            }

            if (request.getCity() != null && !request.getCity().isBlank() && !request.getCity().isEmpty()) {
                sb.append("`Locations`.`city` = ?, ");
                parameters.add(request.getCity());
            }

            if (request.getState() != null && !request.getState().isBlank() && !request.getState().isEmpty()) {
                sb.append("`Locations`.`state` = ?, ");
                parameters.add(request.getState());
            }

            if (request.getCountry() != null && !request.getCountry().isBlank() && !request.getCountry().isEmpty()) {
                sb.append("`Locations`.`country` = ?, ");
                parameters.add(request.getCountry());
            }

            if (request.getAddress() != null && !request.getAddress().isBlank() && !request.getAddress().isEmpty()) {
                sb.append("`Locations`.`address` = ?, ");
                parameters.add(request.getAddress());
            }

            if (request.getContactNumber() != null && !request.getContactNumber().isBlank() && !request.getContactNumber().isEmpty()) {
                sb.append("`Locations`.`contact` = ?, ");
                parameters.add(request.getContactNumber());
            }

            if (request.getLocationID() == 0) throw new Exception("Không có LocationID");
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Locations`.`locationID` = ?;");
            parameters.add(request.getLocationID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readLocation(ServerClient.LocationMetaInfo.newBuilder()
                                .setLocationID(request.getLocationID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteLocation(ServerClient.LocationMetaInfo request, Connection connection) throws Exception {
        System.out.println("deleteLocation");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Locations` WHERE `Locations`.`locationID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            if (request.getLocationID() == 0) throw new Exception("No LocationID provided");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getLocationID());

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
}