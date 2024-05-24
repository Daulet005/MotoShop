package org.example;

import java.sql.*;

public class Authentication {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public boolean authenticateUser(String login, String password) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM customers WHERE login = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, login);
                statement.setString(2, password); // Помните, что перед сравнением пароля лучше его захешировать
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next(); // Если возвращается строка, аутентификация проходит успешно
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
