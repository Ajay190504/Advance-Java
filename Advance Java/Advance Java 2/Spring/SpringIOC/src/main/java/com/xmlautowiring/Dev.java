package com.xmlautowiring;

// @Component // Used in annotation-based configuration
public class Dev {

    private Computer com;
    
    // Used for constructor injection for reference type as arg
//    Dev(Computer com){
//    	this.com=com;
//    }
    
    
    // Setter injection using XML:
    // <property name="com" ref="lap1"/>
    public void setCom(Computer com) {
        this.com = com;
    }

    public Computer getCom() {
        return com;
    }

    public void building() {
        com.compiling();
        System.out.println("Using Building Method");
    }

    @Override
    public String toString() {
        return "Dev [com=" + com + "]";
    }
}