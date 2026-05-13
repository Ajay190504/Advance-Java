package com.xmlautowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowiringbeans.xml");

        Dev obj = context.getBean("dev1", Dev.class);

        obj.building();
    }
}