package com.springAOPdemo.aspect;

import com.springAOPdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private static java.util.logging.Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());



    @Before("com.springAOPdemo.aspect.AOPExpressions.forDAOPackageNoGetterandSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        logger.info("======>>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: "+ methodSignature);

        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            logger.info((String) arg);
            if(arg instanceof Account){
                Account account = (Account) arg;
                logger.info("account name: "+ account.getName());

            }
        }
    }

    @AfterReturning(
            pointcut="execution (* com.springAOPdemo.dao.AccountDAO.findAccounts(..))",
            returning="result")
    public void afterRetuningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n======>>> Executing @AfterReturning on method: "+method);
        logger.info("=====>>>>> result is: "+ result);
    }

    @AfterThrowing(
            pointcut="execution (* com.springAOPdemo.dao.AccountDAO.findAccounts(..))",throwing="exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n======>>> Executing @AfterThrowing on method: "+method);
        logger.info("=====>>>>> Exxeption is: "+ exception);
    }

    @After("execution (* com.springAOPdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n======>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution (* com.springAOPdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n======>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        logger.info("\n=======>> Duration: "+ duration/1000.0 + "seconds");
        return result;
    }
}
