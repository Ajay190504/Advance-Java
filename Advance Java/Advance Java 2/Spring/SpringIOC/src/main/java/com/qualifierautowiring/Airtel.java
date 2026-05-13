package com.qualifierautowiring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("airtelSim") // Explicit bean name
//@Scope("singleton") // default and only one object is created
@Scope("singleton") // Optional, because singleton is default
public class Airtel implements Sim {

    public Airtel() {
        System.out.println("Airtel object created");
    }

    @Override
    public void calling() {
        System.out.println("Calling using Airtel");
    }

    @Override
    public void data() {
        System.out.println("Internet using Airtel");
    }
}