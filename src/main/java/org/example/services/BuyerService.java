//package org.example.services;
//
//import org.example.classes.Buyer;
//import org.example.repositoryes.BuyerRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BuyerService implements UserDetailsService {  // Реализуем интерфейс UserDetailsService
//
//    @Autowired
//    private BuyerRepository buyerRepository;
//
//    // Метод для регистрации покупателя (он не изменится)
//    public Buyer registerBuyer(Buyer buyer) {
//        return buyerRepository.save(buyer);
//    }
//
//    // Реализуем метод loadUserByUsername для UserDetailsService
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        // Ищем покупателя по login и выбрасываем исключение, если не нашли
//        Buyer buyer = buyerRepository.findByLogin(login)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
//
//        // Возвращаем UserDetails. Обычно используются пароль и роли
//        return User.builder()
//                .username(buyer.getLogin()) // Используем login вместо username
//                .password(buyer.getPassword()) // Используем пароль из базы данных
//                .roles("USER") // Вы можете добавить роли, если они есть в модели
//                .build();
//    }
//}
