package org.example.controllers;

import org.example.classes.Cart;
import org.example.classes.CartItem;
import org.example.classes.Product;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    // Добавить товар в корзину
    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        // Получаем корзину из сессии
        Cart cart = (Cart) session.getAttribute("cart");

        // Если корзины нет в сессии, создаем новую
        if (cart == null) {
            cart = new Cart();
        }

        // Получаем продукт по ID
        Product product = productService.getProductById(id).orElse(null);

        if (product != null) {
            // Проверяем, есть ли продукт уже в корзине
            boolean productExists = false;
            for (CartItem item : cart.getItems()) {
                if (item.getProduct().getId().equals(product.getId())) {
                    // Если продукт есть, увеличиваем его количество
                    item.setQuantity(item.getQuantity() + 1);
                    productExists = true;
                    break;
                }
            }

            // Если продукт нет в корзине, добавляем его
            if (!productExists) {
                cart.getItems().add(new CartItem(product, 1));
            }
        }

        // Сохраняем корзину в сессии
        session.setAttribute("cart", cart);

        return "redirect:/cart/view"; // Перенаправляем на страницу просмотра корзины
    }

    // Показать корзину
    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        // Получаем корзину из сессии
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            model.addAttribute("cartItems", cart.getItems()); // Добавляем товары в корзину на страницу
        } else {
            model.addAttribute("cartItems", new ArrayList<>());
        }

        return "Basket"; // Возвращаем представление корзины
    }

    // Очистить корзину после оформления заказа
    @PostMapping("/checkout")
    public String checkout(HttpSession session) {
        // Получаем корзину из сессии
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            // Очищаем корзину
            cart.getItems().clear();
            // Сохраняем пустую корзину в сессии
            session.setAttribute("cart", cart);
        }

        return "redirect:/"; // Перенаправляем на главную страницу
    }
}
