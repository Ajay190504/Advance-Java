package com.springaop.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Runs before every BankService method
    @Before("execution(* com.springaop.bank.service.BankService.*(..))")
    public void logBeforeMethod(JoinPoint jp) {

        System.out.println();
        System.out.println("LOG: Request received for method: "
                + jp.getSignature().getName());

        Object[] args = jp.getArgs();

        for (Object arg : args) {
            System.out.println("LOG: Argument value: " + arg);
        }
    }

    // Runs after every BankService method, whether success or failure
    @After("execution(* com.springaop.bank.service.BankService.*(..))")
    public void logAfterMethod(JoinPoint jp) {

        System.out.println("LOG: Method execution finished: "
                + jp.getSignature().getName());
    }
}