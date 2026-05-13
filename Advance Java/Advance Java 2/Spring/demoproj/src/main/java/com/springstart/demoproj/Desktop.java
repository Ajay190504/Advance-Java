package com.springstart.demoproj;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("desktop") // Giving unique name for identification of bean
//@Primary - used for setting a class as primary when more than one class implents one interface
public class Desktop implements Computer {
	public void compiling() {
		System.out.println("Compiling code on desktop");
	}
}
