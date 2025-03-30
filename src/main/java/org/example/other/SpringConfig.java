//package org.example;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//
//
//@Configuration
//@ComponentScan
//@PropertySource("application.properties")
//public class SpringConfig {
//
//    @Bean("carBean")
//    public Moto getCar(){
//        return new Moto();
//    }
//
//    @Bean("carWithModelValue")
//    public Moto getCarWithModel(@Value("${car.model}") String model){
//        return new Moto(model);
//    }
//
//}