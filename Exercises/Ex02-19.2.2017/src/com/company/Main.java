package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Choose");
        System.out.println("1-Sign up");
        System.out.println("2-Sign in");
        System.out.println("3-Sign out");
        System.out.println("4- Exit");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String choice = null;
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (choice)
        case 1:
            break;

    }
}
