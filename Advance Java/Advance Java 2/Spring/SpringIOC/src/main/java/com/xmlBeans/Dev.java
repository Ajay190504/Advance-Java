package com.xmlBeans;

import org.springframework.beans.factory.annotation.Value;

public class Dev {
	
	@Value("10") //Used to give default value to field
    private int id;
    
	@Value("Ajay")  //Used to give default value to field
    private String name;

	private Laptop lpt1;
	
    public Dev(int id, String name, Laptop lpt1) {
		super();
		this.id = id;
		this.name = name;
		this.lpt1 = lpt1;
	}

	public Laptop getLpt1() {
		return lpt1;
	}

	public void setLpt1(Laptop lpt1) {
		this.lpt1 = lpt1;
	}

	public Dev() {
        System.out.println("XML Dev object created");
    }
	
	//Used for constructor Injection used in springbeans for reference types
//	Dev(Laptop lpt1){
//		this.lpt1=lpt1;
//	}

	//Used for constructor Injection used in springbeans for primitive types
//	Dev(int id){
//		this.id=id;
//	}
	
    public void greet() {
        System.out.println("Hello from XML Based Bean");
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
		return "Dev [id=" + id + ", name=" + name + ", lpt1=" + lpt1 + "]";
	}
}