package com.springAOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    @Before("com.springAOPdemo.aspect.AOPExpressions.forDAOPackageNoGetterandSetter()")
    public void loggingTOCloud(){
        System.out.println("======>>> Logging data to cloud");
    }
}
