package org.example.controllers;

import org.example.classes.CartItem;
import org.example.classes.Product;
import org.example.services.ProductService;
import org.example.services.CartService; // Убедитесь, что у вас есть сервис для работы с корзиной
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Правильный импорт для Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private final ProductService productService;
    private final CartService cartService; // Для работы с корзиной

    // Конструктор для внедрения зависимостей
    @Autowired
    public CatalogController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    // Метод для отображения каталога товаров
    @GetMapping
    public String showCatalog(Model model) {
        List<Product> products = productService.getAllProducts(); // Получаем все товары из сервиса
        model.addAttribute("products", products); // Добавляем товары в модель
        return "Product_Catalog"; // Имя шаблона для отображения каталога
    }

    // Метод для отображения корзины
    @GetMapping("/basket")
    public String showBasket(Model model) {
        List<CartItem> cartItems = cartService.getCartItems(); // Получаем элементы корзины
        model.addAttribute("cartItems", cartItems); // Добавляем корзину в модель
        return "Basket"; // Имя шаблона для отображения корзины
    }
}
