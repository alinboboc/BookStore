package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public Connection conn = null;

    public DatabaseConnection() {
        try {
            String USER = "root";
            String PASS = "root";
            String DB_URL = "jdbc:mysql://localhost:3306/BookStoreDB";

            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASS);

            conn = DriverManager.getConnection(DB_URL, props);

            //Connection test
            //System.out.println("Connection successful!");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
