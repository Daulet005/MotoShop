package org.example.services;

import org.example.classes.CartItem;
import org.example.classes.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    // Используется Map для хранения товаров в корзине по их ID
    private Map<Long, CartItem> cart = new HashMap<>();

    // Добавление товара в корзину
    public void addProduct(Long id, Product product) {
        if (cart.containsKey(id)) {
            // Если товар уже есть в корзине, увеличиваем его количество
            CartItem item = cart.get(id);
            item.setQuantity(item.getQuantity() + 1);
        } else {
            // Если товара нет в корзине, добавляем его с количеством 1
            CartItem newItem = new CartItem(product, 1);
            cart.put(id, newItem);
        }
    }

    // Обновление количества товара в корзине
    public void updateProductQuantity(Long id, int quantity) {
        if (cart.containsKey(id)) {
            // Если товар есть в корзине, обновляем его количество
            CartItem item = cart.get(id);
            item.setQuantity(quantity);
        }
    }

    // Удаление товара из корзины
    public void removeProduct(Long id) {
        cart.remove(id);
    }

    // Очистка корзины (при оформлении заказа)
    public void checkout() {
        cart.clear();
    }

    // Возвращает список товаров, находящихся в корзине
    public List<CartItem> getProducts() {
        return new ArrayList<>(cart.values()); // Конвертируем Map в List
    }

    // Получить все товары в корзине
    public List<CartItem> getCartItems() {
        return getProducts(); // Просто возвращаем список всех товаров
    }
}
