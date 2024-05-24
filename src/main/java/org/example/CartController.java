package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, @RequestParam String brand, @RequestParam String model, @RequestParam String generation, @RequestParam double price) {
        Product product = new Product();
        product.setId(id);
        product.setBrand(brand);
        product.setModel(model);
        product.setGeneration(generation);
        product.setPrice(price);
        cartService.addProduct(id, product);
        return "redirect:/catalog";
    }

    @PostMapping("/cart/update/{id}")
    public String updateCart(@PathVariable Long id, @RequestParam int quantity) {
        cartService.updateProductQuantity(id, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeProduct(id);
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout() {
        cartService.checkout();
        return "redirect:/thank-you";
    }
}
