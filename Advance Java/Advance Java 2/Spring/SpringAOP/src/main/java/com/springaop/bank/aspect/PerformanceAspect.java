package com.springaop.bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    // Around advice controls method execution
    @Around("execution(* com.springaop.bank.service.BankService.*(..))")
    public Object trackExecutionTime(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getSignature().getName();

        System.out.println("PERFORMANCE: Tracking method: " + methodName);

        long start = System.currentTimeMillis();

        try {
            Object result = pjp.proceed(); // actual BankService method runs here

            long end = System.currentTimeMillis();

            System.out.println("PERFORMANCE: " + methodName
                    + " completed in " + (end - start) + " ms");

            return result;

        } catch (Throwable e) {

            System.out.println("PERFORMANCE: " + methodName
                    + " stopped because of error.");

            throw e;
        }
    }
}