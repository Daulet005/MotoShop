package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {

    @GetMapping("/basket")
    public String showBasketPage() {
        return "basket"; // Это должен быть путь к вашему HTML-шаблону для страницы корзины
    }
}

