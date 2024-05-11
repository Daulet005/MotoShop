package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("beanFromClass")
public class Moto {

    @Autowired
    private MotoEngine carEngine;


    @Value("${car.manufacturer}")
    private String manufacturer;

    private String model;

    public Moto(String model){
        this.model = model;
    }

    public Moto(){}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void getEngineModel() {
        System.out.println(carEngine.getEngineTYpe());
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean add(List<Moto> motos) {
        return false;
    }
}