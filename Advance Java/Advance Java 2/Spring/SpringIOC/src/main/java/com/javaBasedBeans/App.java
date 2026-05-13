package com.javaBasedBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Dev dev = context.getBean(Dev.class);
        dev.setId(45);
        dev.setName("Ajay");
        System.out.println(dev);
        dev.greet();
    }
}