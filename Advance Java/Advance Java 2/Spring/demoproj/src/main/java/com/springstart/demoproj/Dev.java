package com.springstart.demoproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev{
	
//	AutoWired DI
	@Autowired // To get objects of entities below from ioc
	@Qualifier("laptop") // Marking specific bean type to be autowired to avoid confusion
	private Computer com;
	
	// DI Using Constructor 
//	public Dev(Laptop lpt) {
//		this.lpt=lpt;
//	}
	
	// DI Using Setter  
//	@Autowired
//	public void setLpt(Laptop lpt) {
//		this.lpt = lpt;
//	}
	
	public void building() {
		com.compiling();
		System.out.println("Using Building Method");
	}
}
