package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int ASCII_0 = 48;
    public static final int ASCII_10 = 57;
    public static final int ASCII_MINUS = 45;


    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//עוזר לקבל קלט מהמשתמש
        System.out.println("please enter a number:");
        String numAsString = null;
        try {
            numAsString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(isInteger(numAsString));
        System.out.println(toInteger(numAsString));
    }

    public static boolean isInteger(String num) {
        if (num == null || num.length() == 0)
            return false;
        int i = 0;
        byte[] numBytes = num.getBytes();
        if (numBytes [0] == ASCII_MINUS)
            i++;
        for (; i < num.length(); i++) {
            if (numBytes[i] < ASCII_0 || numBytes[i] > ASCII_10)
                return false;
        }
        return true;
    }

    public static int toInteger(String num) {
        int result = 0;
        byte[] numBytes = num.getBytes();
        int length = num.length();
        int i = 0;
        int sign = 1;
        if (numBytes [0] == ASCII_MINUS) {
            i++;
            sign *= -1;
        }
        for (; i < length; i++)
            result = result * 10 + (numBytes[i] - ASCII_0);
        return sign*result;
    }
}
