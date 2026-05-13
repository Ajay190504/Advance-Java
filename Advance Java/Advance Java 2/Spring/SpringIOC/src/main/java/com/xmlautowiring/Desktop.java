package com.xmlautowiring;

// @Component("desktop") // Used in annotation-based configuration
// @Primary // Used when this bean should be preferred by default
public class Desktop implements Computer {

    @Override
    public void compiling() {
        System.out.println("Compiling code on desktop");
    }
}