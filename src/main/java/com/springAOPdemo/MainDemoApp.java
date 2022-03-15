package com.springAOPdemo;

import com.springAOPdemo.dao.AccountDAO;
import com.springAOPdemo.dao.MembershipDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Logger logger = LogManager.getLogger("MainDemoApp");

//        Account account = new Account();
//        account.setName("Rishi");
//        account.setLevel("Diamond");
//        accountDAO.addAccount(account, true);
//        accountDAO.doWork();
//        accountDAO.getName();
        accountDAO.findAccounts(false);

//        membershipDAO.addAccount();
//        membershipDAO.setName("John");
//        membershipDAO.goToSleep();
//        membershipDAO.getName();
        context.close();
    }
}
