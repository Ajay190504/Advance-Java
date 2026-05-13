package com.qualifierautowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") // default and only one object is created 
@Scope("prototype") // New Mobile object will be created every time getBean(Mobile.class) is called
public class Mobile {

    @Autowired
    @Qualifier("airtelSim") // Explicitly inject Airtel bean
    private Sim sim;

    public Mobile() {
        System.out.println("Mobile object created");
    }

    public void useSim() {
        sim.calling();
        sim.data();
    }
}