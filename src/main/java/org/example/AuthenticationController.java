//package org.example;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthenticationController {
//
//    @Autowired
//    private BuyerRepository buyerRepository;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest request) {
//        String login = request.getLogin();
//        String password = request.getPassword();
//
//        // Проверяем пользователя в базе данных
//        Buyer buyer = buyerRepository.findByUsername(login);
//        if (buyer == null || !buyer.getPassword().equals(password)) {
//            // Если пользователь не найден или пароль неверный, возвращаем ошибку
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверное имя пользователя или пароль");
//        } else {
//            // Если пользователь найден и пароль совпадает, возвращаем успешный результат
//            return ResponseEntity.ok("Аутентификация прошла успешно");
//        }
//    }
//}