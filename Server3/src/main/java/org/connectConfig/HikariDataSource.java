package org.connectConfig;

import com.zaxxer.hikari.HikariConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariDataSource {
    private static HikariConfig config = new HikariConfig();
    private static com.zaxxer.hikari.HikariDataSource ds;

    static {
        config.setJdbcUrl(ENVMySQL.URL);
        config.setUsername(ENVMySQL.USERNAME);
        config.setPassword(ENVMySQL.PASSWORD);
        config.setMaximumPoolSize(ENVMySQL.MAX_POOL_SIZE);
        config.setMinimumIdle(ENVMySQL.MIN_POOL_SIZE);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(60000);
        config.setPoolName("HikariConnPool");
        ds = new com.zaxxer.hikari.HikariDataSource( config );
    }

    private HikariDataSource() {}

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static com.zaxxer.hikari.HikariDataSource getDataSource() {
        return ds;
    }
}
