
package org.example.other;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    // Простая "база данных" пользователей с использованием HashMap
    private static final Map<String, String> users = new HashMap<>();

    static {
        // Заполнение "базы данных" пользователей именем пользователя и паролем
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3"); // Добавьте больше пользователей по необходимости
    }

    public boolean authenticateUser(String login, String password) {
        // Проверка, существует ли логин и совпадает ли пароль
        return users.containsKey(login) && users.get(login).equals(password);
    }

    public static void main(String[] args) {
        Authentication auth = new Authentication();

        // Пример аутентификации пользователя
        String login = "user1"; // Замените на фактический ввод
        String password = "password1"; // Замените на фактический ввод

        if (auth.authenticateUser(login, password)) {
            System.out.println("Аутентификация прошла успешно!");
        } else {
            System.out.println("Аутентификация не удалась!");
        }
    }
}
