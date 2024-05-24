package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Transactional
    public boolean authenticate(String login, String password) {
        Buyer buyer = buyerRepository.findByLogin(login);
        return buyer != null && buyer.getPassword().equals(password);
    }
}