package com.springaop.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    // Extra validation only for transferMoney method
    @Before("execution(* com.springaop.bank.service.BankService.transferMoney(..))")
    public void validateTransferLimit(JoinPoint jp) {

        Object[] args = jp.getArgs();

        String receiverName = (String) args[0];
        double amount = (double) args[1];

        System.out.println("VALIDATION: Checking transfer details.");
        System.out.println("VALIDATION: Receiver: " + receiverName);
        System.out.println("VALIDATION: Amount: Rs. " + amount);

        if (amount > 25000) {
            throw new RuntimeException("Transfer limit exceeded. Maximum allowed is Rs. 25000.");
        }

        System.out.println("VALIDATION: Transfer limit valid.");
    }
}