package com.springstart.demoproj;

import org.springframework.stereotype.Component;

@Component("laptop") // Giving unique name for identification of bean
//@Primary - used for setting a class as primary when more than one class implements one interface
public class Laptop implements Computer {
	
	public void compiling() {
		System.out.println("Compiling code on laptop");
	}
	
	
}
