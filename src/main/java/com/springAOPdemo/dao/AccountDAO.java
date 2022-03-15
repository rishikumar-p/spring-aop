package com.springAOPdemo.dao;

import com.springAOPdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) throws Exception {
        if(tripWire){
            throw new RuntimeException("Testing the AfterThrowing advice");
        }
        List<Account> myAccounts = new ArrayList<Account>();
        myAccounts.add(new Account("John", "Silver"));
        myAccounts.add(new Account("Walter", "Gold"));
        myAccounts.add(new Account("Micheal", "Platinum"));
        System.out.println("Inside AccountDAO: findAccounts method");
        return  myAccounts;
    }

    public void addAccount(Account account, boolean isTrue) {
        System.out.println(getClass()+": Doing MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass()+": Doing MY DB WORK: Doing my WORK");
        return false;
    }

    public String getName(){
        System.out.println(getClass()+ " in getName");
        return this.name;
    }

    public void setName(String name){
        System.out.println(getClass()+ " in setName");
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
