package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/buyers/registration")
    public ResponseEntity<?> registerBuyer(@RequestBody Buyer buyer) {
        Buyer registeredBuyer = buyerService.registerBuyer(buyer);
        return new ResponseEntity<>(registeredBuyer, HttpStatus.CREATED);
    }
}

