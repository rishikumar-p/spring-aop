package com.springAOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAPIAnalyticsAspect {

    @Before("com.springAOPdemo.aspect.AOPExpressions.forDAOPackageNoGetterandSetter()")
    public void performAPIAnalytics(){
        System.out.println("======>>> Performing API Analytics");
    }
}
