package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product_catalog")
public class ProductCatalogController {

    private final ProductService productService;

    @Autowired
    public ProductCatalogController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductCatalogPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product_catalog"; // Путь к вашему HTML-шаблону для каталога товаров
    }
}
