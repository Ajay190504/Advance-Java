package com.springaop.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    // Runs only when any BankService method throws exception
    @AfterThrowing(
            pointcut = "execution(* com.springaop.bank.service.BankService.*(..))",
            throwing = "ex"
    )
    public void logException(JoinPoint jp, Exception ex) {

        System.out.println("EXCEPTION: Operation failed.");
        System.out.println("EXCEPTION: Method: "
                + jp.getSignature().getName());
        System.out.println("EXCEPTION: Reason: "
                + ex.getMessage());
    }
}