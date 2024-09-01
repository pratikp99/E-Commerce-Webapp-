package com.revature.ecom.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static Connection conn;

    public static Connection getConnection() throws ClassNotFoundException {
        if (conn == null) {
            try {
                Properties props = new Properties();
                InputStream inputStream = DatabaseUtil.class.getClassLoader().getResourceAsStream("utils.properties");
                props.load(inputStream);

                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Error loading MySQL JDBC driver", e);
                }

                conn = DriverManager.getConnection(url, username, password);
            } catch (IOException | SQLException e) {
                throw new RuntimeException("Error establishing database connection", e);
            }
        }
        return conn;
    }
}
