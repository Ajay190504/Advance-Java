package com.qualifierautowiring;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("jioSim") // Explicit bean name
//@Scope("singleton") // default and only one object is created
@Primary // Default choice if multiple Sim beans exist
@Scope("singleton") // Optional, because singleton is default
public class Jio implements Sim {

    public Jio() {
        System.out.println("Jio object created");
    }

    @Override
    public void calling() {
        System.out.println("Calling using Jio");
    }

    @Override
    public void data() {
        System.out.println("Internet using Jio");
    }
}