package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private Map<Long, CartItem> cart = new HashMap<>();

    public void addProduct(Long id, Product product) {
        if (cart.containsKey(id)) {
            CartItem item = cart.get(id);
            item.setQuantity(item.getQuantity() + 1); // Увеличение количества, если продукт уже есть в корзине
        } else {
            CartItem newItem = new CartItem(product, 1);
            cart.put(id, newItem);
        }
    }

    public void updateProductQuantity(Long id, int quantity) {
        if (cart.containsKey(id)) {
            CartItem item = cart.get(id);
            item.setQuantity(quantity); // Обновление количества продукта в корзине
        }
    }

    public void removeProduct(Long id) {
        cart.remove(id); // Удаление продукта из корзины
    }

    public void checkout() {
        cart.clear(); // Очистка корзины при оформлении заказа
    }

    public List<CartItem> getProducts() {
        return new ArrayList<>(cart.values()); // Возвращение списка продуктов в корзине
    }
}
