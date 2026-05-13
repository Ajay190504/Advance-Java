package com.javaBasedBeans;

public class Dev {

    private int id;
    private String name;

    public Dev() {
        System.out.println("Java Based Dev object created");
    }

    public void greet() {
        System.out.println("Hello from Java Based Bean");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    @Override
    public String toString() {
        return "Dev [id=" + id + ", name=" + name + "]";
    }
}