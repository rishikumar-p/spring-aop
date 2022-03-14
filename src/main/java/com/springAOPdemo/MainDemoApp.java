package com.springAOPdemo;

import com.springAOPdemo.dao.AccountDAO;
import com.springAOPdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();
        accountDAO.setName("Rishi");
        accountDAO.getName();

        System.out.println();

        membershipDAO.addAccount();
        membershipDAO.goToSleep();
        membershipDAO.setName("John");
        membershipDAO.getName();
        context.close();
    }
}
