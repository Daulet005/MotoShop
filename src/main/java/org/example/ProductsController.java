package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products"; // Имя представления каталога товаров
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String generation,
            @RequestParam double price,
            Model modelAndView) {

        Product p = new Product();
        p.setBrand(brand);
        p.setModel(model);
        p.setGeneration(generation);
        p.setPrice(price);

        productService.addProduct(p);

        return "redirect:/products";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteProductById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Продукт успешно удален");
        return "redirect:/products";
    }

}