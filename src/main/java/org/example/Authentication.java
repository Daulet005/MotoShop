package org.example;

import java.sql.*;

public class Authentication {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public boolean authenticateUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM customers WHERE username = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password); // Remember to hash the password before comparing
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next(); // If a row is returned, authentication succeeds
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
