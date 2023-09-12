package com.java.bean;

public class PersonImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("person run...");
    }
}
