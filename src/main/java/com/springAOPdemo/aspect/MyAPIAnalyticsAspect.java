package com.springAOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyAPIAnalyticsAspect {

    private static java.util.logging.Logger logger = Logger.getLogger(MyAPIAnalyticsAspect.class.getName());

    @Before("com.springAOPdemo.aspect.AOPExpressions.forDAOPackageNoGetterandSetter()")
    public void performAPIAnalytics(){
        logger.info("======>>> Performing API Analytics");
    }
}
