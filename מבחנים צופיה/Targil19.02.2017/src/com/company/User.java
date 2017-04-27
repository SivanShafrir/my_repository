package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by hackeru on 2/19/2017.
 */
public class User {
    public static final int ASCII_a = 97;
    public static final int ASCII_z = 122;
    private String userName;
    private String password;

    public User() {
        setUserName();
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        System.out.println("enter user name");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        byte[] sBytes = userName.getBytes();
        for (int i = 0; i <sBytes.length ; i++) {
            if(sBytes[0] < ASCII_a && sBytes[0] > ASCII_z){

            }

        }


        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
