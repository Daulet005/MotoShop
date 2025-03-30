//package org.example.services.;
//
//import org.example.classes.Order;
//import org.example.repositoryes.OrderRepositiry;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderService {
//
//    private final OrderRepository orderRepository;
//
//    @Autowired
//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    public void placeOrder(Order order) {
//        // Сохраняем заказ в базу данных
//        orderRepository.save(order);
//
//        // Выводим в консоль для отладки
//        System.out.println("Order placed successfully!");
//    }
//}
