//package org.example;
//
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
//public class SpringStarterApplication {
//    public static void main(String[] args) {
//
//        ApplicationContext ctx = new
//                AnnotationConfigApplicationContext(SpringConfig.class);
//
//        Moto car = ctx.getBean("carWithModelValue" , Moto.class);
//
//        car.getEngineModel();
//
//        System.out.println(car.getManufacturer());
//
//        System.out.println(car.getModel());
//    }
//
//}