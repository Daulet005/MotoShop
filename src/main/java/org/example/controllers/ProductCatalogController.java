package org.example.controllers;

import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCatalogController {

    private final ProductService productService;

    @Autowired
    public ProductCatalogController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product_catalog")
    public String showProductCatalog(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "Product_Catalog"; // имя вашего HTML-шаблона
    }
}
