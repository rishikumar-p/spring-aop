package com.springAOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

    @Before("com.springAOPdemo.aspect.AOPExpressions.forDAOPackageNoGetterandSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("======>>> Executing @Before advice on addAccount()");
    }
}
