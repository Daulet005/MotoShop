package org.example.repositoryes;

import org.apache.catalina.User;
import org.example.classes.Buyer;
import org.example.classes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByBuyer(Buyer buyer);
}
