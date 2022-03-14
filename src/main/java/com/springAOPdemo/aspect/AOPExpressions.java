package com.springAOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
    @Pointcut("execution(* com.springAOPdemo.dao.*.*(..))")
    public void forDaoPackage(){
    }

    @Pointcut("execution(* com.springAOPdemo.dao.*.get*(..))")
    public void getter(){
    }

    @Pointcut("execution(* com.springAOPdemo.dao.*.set*(..))")
    public void setter(){
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterandSetter(){}
}
