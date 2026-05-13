package com.springaop.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    // Runs only after successful deposit, withdraw, or transferMoney
    @AfterReturning(
            pointcut = "execution(* com.springaop.bank.service.BankService.deposit(..)) || "
                    + "execution(* com.springaop.bank.service.BankService.withdraw(..)) || "
                    + "execution(* com.springaop.bank.service.BankService.transferMoney(..))"
    )
    public void auditSuccessfulTransaction(JoinPoint jp) {

        System.out.println("AUDIT: Transaction completed successfully.");
        System.out.println("AUDIT: Transaction type: "
                + jp.getSignature().getName());
    }

    // Runs only after checkBalance successfully returns value
    @AfterReturning(
            pointcut = "execution(* com.springaop.bank.service.BankService.checkBalance(..))",
            returning = "balance"
    )
    public void auditBalanceCheck(JoinPoint jp, Object balance) {

        System.out.println("AUDIT: Balance enquiry completed.");
        System.out.println("AUDIT: Returned balance: Rs. " + balance);
    }
}