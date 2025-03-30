package org.example.classes;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer; // Покупатель, который владеет корзиной

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>(); // Список товаров в корзине

    // Конструктор по умолчанию
    public Cart() {
    }

    // Конструктор для инициализации с покупателем
    public Cart(Buyer buyer) {
        this.buyer = buyer;
    }

    // Геттеры и сеттеры для id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Геттеры и сеттеры для покупателя
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    // Геттеры и сеттеры для товаров в корзине
    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    // Метод для вычисления общей стоимости корзины
    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    // Метод для добавления товара в корзину
    public void addItem(CartItem cartItem) {
        this.items.add(cartItem);
    }

    // Метод для удаления товара из корзины
    public void removeItem(CartItem cartItem) {
        this.items.remove(cartItem);
    }

    // Метод для очистки корзины
    public void clear() {
        this.items.clear();
    }

    // Метод для обновления количества товара в корзине
    public void updateQuantity(CartItem cartItem, int quantity) {
        for (CartItem item : items) {
            if (item.equals(cartItem)) {
                item.setQuantity(quantity);
                break;
            }
        }
    }
}
