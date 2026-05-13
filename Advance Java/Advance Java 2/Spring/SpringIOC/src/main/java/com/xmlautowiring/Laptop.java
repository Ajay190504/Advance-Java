package com.xmlautowiring;

// @Component("laptop") // Used in annotation-based configuration
// @Primary // Used when multiple classes implement same interface
public class Laptop implements Computer {

    @Override
    public void compiling() {
        System.out.println("Compiling code on laptop");
    }
}