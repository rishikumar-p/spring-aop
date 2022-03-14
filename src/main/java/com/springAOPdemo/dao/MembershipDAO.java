package com.springAOPdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    private String name;

    public boolean addAccount(){
        System.out.println(getClass()+": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass()+": DOING STUFF: GOING TO SLEEP");
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
