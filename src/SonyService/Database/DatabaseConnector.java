package SonyService.Database;

import SonyService.Models.Movie;
import SonyService.SonyService;

import java.sql.*;

public class DatabaseConnector {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String DB_USER = "root";
    static final String DB_PASS = "@lf@";

    private Connection conn = null;

    public DatabaseConnector() {
        connectDatabase();
    }

    public void connectDatabase() {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");


        try {
            conn = DriverManager
                    .getConnection(DB_URL, DB_USER, DB_PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Loading from XML Sheets");
            e.printStackTrace();
            return;
        }

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public Connection getConn() {
        return conn;
    }




}
