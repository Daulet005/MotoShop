package org.example.classes;

import java.util.List;

public class Order {
    private List<CartItem> items; // Список товаров
    private double total; // Общая стоимость

    public Order(Cart cart) {
        this.items = cart.getItems(); // Все товары из корзины
        this.total = cart.getTotal(); // Общая стоимость корзины
    }

    // Геттеры и сеттеры
    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
