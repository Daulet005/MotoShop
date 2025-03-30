package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Главная страница
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("username", "Katy");
        model.addAttribute("color", "red");
        return "index";  // Thymeleaf автоматически найдет index.html в папке templates
    }

    // Страница входа
    @GetMapping("/login")
    public String loginPage() {
        return "home";  // Thymeleaf автоматически найдет home.html в папке templates
    }
}
