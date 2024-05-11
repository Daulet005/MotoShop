package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    //Buyer findByUsername(String login);
    // Здесь можно добавить дополнительные методы для работы с покупателями, если это необходимо
}

