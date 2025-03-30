package org.example.services;

import org.example.classes.Buyer;
import org.example.repositoryes.BuyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthenticationService {

    private BuyerRepository buyerRepository;

    // Конструктор, чтобы инициализировать зависимость вручную
    public AuthenticationService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Transactional
    public boolean authenticate(String login, String password) {
        // Используем Optional для безопасного извлечения покупателя
        Optional<Buyer> optionalBuyer = buyerRepository.findByLogin(login);

        // Проверяем, существует ли покупатель и совпадает ли пароль
        if (optionalBuyer.isPresent()) {
            // В данной версии просто сравниваем пароли напрямую (без хеширования)
            return password.equals(optionalBuyer.get().getPassword());
        }

        return false; // Если покупателя не найдено, возвращаем false
    }
}
