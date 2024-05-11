package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer registerBuyer(Buyer buyer) {
        // Можно добавить здесь логику для валидации или обработки данных покупателя перед сохранением
        return buyerRepository.save(buyer);
    }
}

