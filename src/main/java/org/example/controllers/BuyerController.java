package org.example.controllers;

import org.example.classes.Buyer;
import org.example.repositoryes.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerRepository buyerRepository; // Внедряем репозиторий для работы с базой данных

    @PostMapping("/registration")
    public ResponseEntity<?> registerBuyer(@RequestBody Buyer buyer) {
        // Сохраняем покупателя в базу данных
        buyerRepository.save(buyer);

        return ResponseEntity.status(HttpStatus.CREATED).body("Пользователь успешно зарегистрирован");
    }
}
