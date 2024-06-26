package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
