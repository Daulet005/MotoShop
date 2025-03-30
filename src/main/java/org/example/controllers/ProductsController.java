package org.example.controllers;

import org.example.classes.Product;
import org.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productsService;

    public ProductsController(ProductService productService) {
        this.productsService = productService;
    }

    // Показать страницу с продуктами
    @GetMapping
    public ModelAndView showProductsPage() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productsService.getAllProducts());
        return modelAndView;
    }

    // Получить продукт по ID
    @GetMapping("/{id}")
    public ModelAndView getProductById(@PathVariable Long id) {
        Optional<Product> product = productsService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView("productDetails");
        modelAndView.addObject("product", product.orElse(null));
        return modelAndView;
    }

    // Создать новый продукт
    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productsService.createProduct(product);
        return "redirect:/products"; // Перенаправление после добавления
    }

    // Удалить продукт (изменен метод для поддержки _method=DELETE)
    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return "redirect:/products"; // Перенаправление после удаления
    }
}
