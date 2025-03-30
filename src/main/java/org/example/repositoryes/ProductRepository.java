package org.example.repositoryes;

import org.example.classes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Здесь можно добавить дополнительные методы для кастомных запросов, если нужно
}
