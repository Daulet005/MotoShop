package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration"; // Это имя представления (view name), которое соответствует registration.html
    }
}

