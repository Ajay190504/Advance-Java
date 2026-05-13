package com.springaop.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    // Security check only for withdraw and transfer
    @Before("execution(* com.springaop.bank.service.BankService.withdraw(..)) || "
            + "execution(* com.springaop.bank.service.BankService.transferMoney(..))")
    public void checkUserPermission(JoinPoint jp) {

        System.out.println("SECURITY: Checking permission for: "
                + jp.getSignature().getName());

        String loggedInUser = "Ajay";

        if (loggedInUser.equals("Ajay")) {
            System.out.println("SECURITY: User authorized.");
        } else {
            throw new RuntimeException("Unauthorized user.");
        }
    }
}