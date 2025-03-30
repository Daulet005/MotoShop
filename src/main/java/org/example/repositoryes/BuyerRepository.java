package org.example.repositoryes;

import org.example.classes.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    // Метод для поиска покупателя по логину
    Optional<Buyer> findByLogin(String login);

    // Метод для проверки, существует ли покупатель с данным логином
    boolean existsByLogin(String login);
}
