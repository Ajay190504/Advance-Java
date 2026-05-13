package com.springaop.bank;

import com.springaop.bank.config.AppConfig;
import com.springaop.bank.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BankService bankService = context.getBean(BankService.class);

        bankService.deposit(5000);

        bankService.withdraw(2000);

        bankService.transferMoney("Rahul", 3000);

        double balance = bankService.checkBalance();
        System.out.println("MAIN: Balance received in main: Rs. " + balance);

        // This line is intentionally written to test @AfterThrowing advice
        bankService.withdraw(50000);
    }
}