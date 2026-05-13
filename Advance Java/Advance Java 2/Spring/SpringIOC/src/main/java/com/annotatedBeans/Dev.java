package com.annotatedBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Value("201")
    private int id;

    @Value("Annotation Ajay")
    private String name;

    public Dev() {
        System.out.println("Annotation Dev object created");
    }

    public void greet() {
        System.out.println("Hello from Annotation Based Bean");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dev [id=" + id + ", name=" + name + "]";
    }
}