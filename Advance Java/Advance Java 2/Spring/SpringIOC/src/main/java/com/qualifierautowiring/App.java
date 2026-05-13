package com.qualifierautowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Mobile m1 = context.getBean(Mobile.class);
        Mobile m2 = context.getBean(Mobile.class);

        System.out.println("m1 hashCode: " + m1.hashCode());
        System.out.println("m2 hashCode: " + m2.hashCode());

        System.out.println("Are both Mobile objects same? " + (m1 == m2));

        m1.useSim();
    }
}