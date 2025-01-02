package org.controller;

import org.DAO.RoleDAO;
import org.DAO.WishListDAO;
import org.connectConfig.HikariDataSource;
import org.model.Roles;
import proto.ServerClient;

import java.sql.Connection;

public class WishListController {
    public ServerClient.WishListFullInfo wishListRegister(ServerClient.WishListFullInfo request) throws Exception {
        WishListDAO wishListDAO = new WishListDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            ServerClient.WishListFullInfo ans = wishListDAO.registerWishList(request, connection);
            connection.commit();
            return ans;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public ServerClient.WishListFullInfo wishListUpdate(ServerClient.WishListFullInfo request) throws Exception {
        WishListDAO wishListDAO = new WishListDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            ServerClient.WishListFullInfo ans = wishListDAO.updateWishList(request, connection);
            connection.commit();
            return ans;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public ServerClient.WishListFullInfo wishListRead(ServerClient.UserMetaInfo request) throws Exception {
        WishListDAO wishListDAO = new WishListDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            ServerClient.WishListFullInfo ans = wishListDAO.readWishList(request, connection);
            connection.commit();
            return ans;
        }
        finally {
            if (connection != null) connection.close();
        }
    }
}
