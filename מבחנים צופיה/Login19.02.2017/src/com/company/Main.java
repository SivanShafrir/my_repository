package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.User.checkingPassWord;
import static com.company.User.checkingUsername;

public class Main {


    public static void main(String[] args) throws IOException {

        ArrayList<User> users=new ArrayList<>();

        System.out.println("to sigh up enter 1");
        System.out.println("to log in enter 2");
        System.out.println("to log out enter 3 ");
        System.out.println("to exit  enter 4 ");
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter your select :");
        String select = bufferedReader.readLine();
        User user1=new User("ss123456","shira1234");
        switch(select){

            case "1":
                boolean checkU=false;
                while (!checkU) {
                    System.out.println("enter your user name");
                    String userName = bufferedReader.readLine();
                    checkU = checkingUsername(userName,users);
                }
                boolean checkP=false;
                while (!checkP){
                    System.out.println("enter your user name");
                    String password = bufferedReader.readLine();
                    System.out.println("enter your confirmPassword");
                    String confirmPassword = bufferedReader.readLine();
                    checkP = checkingPassWord(password,confirmPassword);
                }
                add(users);
            break ;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println();


        }
    }



}

