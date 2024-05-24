package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/check-login")
    public ResponseEntity<?> authenticateBuyer(@RequestBody AuthenticationRequest request) {
        String login = request.getLogin();
        String password = request.getPassword();

        // Проверка аутентификации пользователя с использованием сервиса AuthenticationService
        boolean isAuthenticated = authenticationService.authenticate(login, password);
        if (isAuthenticated) {
            return ResponseEntity.ok().build(); // Возвращаем успешный статус, если аутентификация успешна
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверное имя пользователя или пароль");
        }
    }
}
