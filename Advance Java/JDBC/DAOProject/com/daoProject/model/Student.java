package com.daoProject.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String city;

    public Student() {}

    public Student(int id, String name, int age, String city) {
        this.id = id;
        this.name = name != null ? name.trim() : null;
        this.age = age;
        this.city = city != null ? city.trim() : null;
    }

    // Getters & Setters
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
        this.name = name != null ? name.trim() : null; 
    }

    public int getAge() { 
        return age; 
    }

    public void setAge(int age) { 
        this.age = age; 
    }

    public String getCity() { 
        return city; 
    }

    public void setCity(String city) { 
        this.city = city != null ? city.trim() : null; 
    }

    // Overriding toString()
    @Override
    public String toString() {
        return "Student [id=" + id +
               ", name=" + name +
               ", age=" + age +
               ", city=" + city + "]";
    }
}