package org.example.classes;

import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name = "products")  // Название таблицы в базе данных
public class Product {

    @Id  // Это основное поле, которое будет использоваться как уникальный идентификатор
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация значений id
    private Long id;

    @Column(name = "brand")  // Название столбца в базе данных
    private String brand;

    @Column(name = "model")  // Название столбца в базе данных
    private String model;

    @Column(name = "generation")  // Название столбца в базе данных
    private String generation;

    @Column(name = "price")  // Название столбца в базе данных
    private double price;



    // Конструктор по умолчанию
    public Product() {}

    // Конструктор с параметрами
    public Product(Long id, String brand, String model, String generation, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.generation = generation;
        this.price = price;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Метод для форматирования цены
    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", generation='" + generation + '\'' +
                ", price=" + price +
                '}';
    }
}
