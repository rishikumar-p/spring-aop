package com.springAOPdemo.dao;

import com.springAOPdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;

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

}
