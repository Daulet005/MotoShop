package org.example.services;

import org.example.classes.Product;
import org.example.repositoryes.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Получить все продукты
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Получить продукт по ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Создать новый продукт
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Обновить продукт
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null; // Можно выбросить исключение
    }

    // Удалить продукт
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
