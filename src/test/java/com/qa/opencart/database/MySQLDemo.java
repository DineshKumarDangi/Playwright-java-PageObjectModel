package com.qa.opencart.database;

//import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLDemo {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3307/d_docker_db"; // replace 'company' with your DB name
        String user = "root"; // replace with your DB username
        String password = "my-secret-pw"; // replace with your DB password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            Statement stmt = conn.createStatement();
/*
            // 1. Create table
            String createTable = "CREATE TABLE IF NOT EXISTS login (" +
                    "userId INT PRIMARY KEY AUTO_INCREMENT," +
                    "userName VARCHAR(50)," +
                    "userPassword VARCHAR(30)," +
                    "userType VARCHAR(10)," +
                    "expectedResult  VARCHAR(4))";

            stmt.executeUpdate(createTable);
            System.out.println("Table 'employee' created.");

            // 2. Insert data
            String insertData =
                    "INSERT INTO login (userName, userPassword, userType,expectedResult)" +
                    "VALUES  ('Alice', 'Alice', 'CA','pass')," +
                    "('Bob', 'Bob', 'CO','pass')," +
                    "('Charlie', 'Charlie','ADMIN','pass')";

            stmt.executeUpdate(insertData);
            System.out.println("Data inserted into 'employee'.");
/**/
            // 3. Fetch selected rows
            String selectQuery = "SELECT userId, userName, userPassword, userType,expectedResult FROM login";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("ALL USERS:");
            while (rs.next()) {
                int userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String userPassword = rs.getString("userPassword");
                String userType = rs.getString("userType");
                String expectedResult = rs.getString("expectedResult");

                System.out.printf("userId: %d, userName: %s, userPassword: %s, userType: %s, expectedResult: %s ", userId, userName, userPassword, userType,expectedResult +"\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
