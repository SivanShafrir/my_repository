package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hackeru on 2/19/2017.
 */
public class User {
    public static final int ASCII_a = 97;
    public static final int ASCII_z = 122;
    public String userName;
    public  String password;

    public User() {
        setUserName();
        setPassword(password);
    }

    private void setUserName() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//עוזר לקבל קלט מהמשתמש
        System.out.println("Enter User name:");
        String userName = null;
        try {
            userName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i< userName.length();i++){
            if (userName[i] < ASCII_a && userName[i] > ASCII_z)
        }

        this.userName = userName;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
