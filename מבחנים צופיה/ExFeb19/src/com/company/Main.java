package com.company;
import java.io.*;
import java.security.InvalidParameterException;

public class Main {
    static final int ASCII_0 = 48;
    static Listy<User> users;
    // Todo: its always better to use interface to make implementation more general
    static User loggedInUser;
    public static void main(String[] args) {
        users = new ArrayListy<>();
        loggedInUser = null;
        printMenu();
    }
    static String readInput(){
        String input=null;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
       return input;
    }
    static void andAction(int choice){
        switch (choice){
            case 1:
                signUp();
                break;
            case 2:
                signIn();
                break;
            case 3:
                flipString();
                break;
            case 4:
                signOut();
                break;
            case 5:
                System.out.println("Exiting");
                return;
            default:
                System.out.println("Invalid option");
        }
        printMenu();
    }
    static void flipString(){
        if(loggedInUser != null){
            System.out.println("All right! Ready to do some serious String-flipping?");
            System.out.println("Enter your String:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String toFlip=bufferedReader.readLine();
                System.out.println("Flipped String: " + reverseString(toFlip));
            }
            catch (IOException ex){
                System.out.println("Error reading");
            }
        }
        else
            System.out.println("Sorry, we know you'd love to use this feature, but you have to be a member first");
    }
    static void signUp(){
        String user=null;
        String pw=null;
        int counter=0;
        System.out.println("Enter username between 3-20 characters. It must contain lowercase letters, and may end with numbers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            user=bufferedReader.readLine();
            while ((!isValid(user,true) || userExists(user) != -1) && counter < 3) {
                System.out.println("Please enter another username. The username you picked either exists or is invalid");
                user = bufferedReader.readLine();
                counter++;
                if (counter == 3) { //after 3 failed tries exit to main menu
                    System.out.println("Error. Returning to main menu");
                    printMenu();
                }
            }
        }
        catch (IOException ex){
            System.out.println("Error reading");
        }
        counter=0;
        System.out.println("Enter password between 4-12 characters. It may contain letters, characters and numbers");
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
        try {
            pw=bufferedReader.readLine();
            System.out.println("Confirm password");
            String pw2=bufferedReader.readLine();
            while((!isValid(pw,false) || !pw.equals(pw2)) && counter<3) {
                System.out.println("Please re-enter password");
                pw = bufferedReader.readLine();
                System.out.println("Confirm new password");
                pw2 = bufferedReader.readLine();
                counter++;
                if (counter == 3) {
                    System.out.println("Error. Returning to main menu");
                    printMenu();
                }
            }
        }
        catch (IOException ex){
            System.out.println("error reading");
        }
        loggedInUser=new User(user,pw);
        users.add(loggedInUser);
    }
    static void signOut(){
        System.out.println("You are now signed out of our awesome app");
        System.out.println("But we know you'll be back soon");
        loggedInUser=null;
    }
    static int userExists (String str){
        for (int i = 0; i < users.getSize() ; i++)
            if(users.get(i).getUsername().toUpperCase().equals(str.toUpperCase()))
                return i;
        return -1;
    }
    static boolean isValid (String str, boolean user){
       if(user){
           boolean digitFound=false;
            if(str.length() < 4 || str.length() > 20)
                return false;
            byte[] checker = str.getBytes();
            for (int i = 0; i < checker.length; i++) {
                if(i == 0 && !isLowercase(checker[i]) || (i!=0 && !isLowercase(checker[i]) && !isNumber(checker[i])))
                    return false;
                if(isNumber(checker[i]))
                    digitFound=true;
                if(digitFound && !isNumber(checker[i]))
                    return false;
            }
            return true;
       } //else if is password
        byte[] checker = str.getBytes();
        if(checker.length < 4 || checker.length > 12)
            return false;
        for (int i = 0; i < checker.length; i++) {
            if(checker[i] < ASCII_0 || checker[i] > 126)
                return false;
        }
        return true;
    }
    static boolean isLowercase(byte c){return (c <= 122 && c >= 97);}
    static boolean isNumber (byte c){return (c <= 57 && c >= 48);}
    static void printMenu(){
        System.out.println("*******************************************");
        System.out.println("Welcome to this crazily awesome application");
        System.out.println("You have never seen anything like this");
        System.out.println("Choose an option from the following list");
        System.out.println("1- Sign up to our app");
        System.out.println("2- Sign in to our app");
        System.out.println("3- Reverse a string (Available to members only, so hurry up and become one)");
        System.out.println("4- Sign out");
        System.out.println("5- Exit");
        System.out.println("*******************************************");
        System.out.println("Your input: ");
 /*       try {
            int nextByte = System.in.read();
            if(nextByte == -1)
                throw new InvalidParameterException("input error");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice = bufferedReader.readLine();
            andAction(Integer.parseInt(choice));
        }
        catch (IOException ex){
            System.out.println("error reading");
        }
    }
    static boolean signIn(){
        if(loggedInUser!=null) {
            System.out.println(loggedInUser.getUsername()+ ", you are already signed in!");
            return true;
        }
        System.out.println("Enter your username");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String user = bufferedReader.readLine();
            while(userExists(user) == -1) {
                System.out.println("You don't seem to be a member. Please press 1 to sign up in main menu");
                user = bufferedReader.readLine();
                if(user.equals("1"))
                    printMenu();
            }
            User u=users.get(userExists(user));
            System.out.println("Enter your password");
            String pw=bufferedReader.readLine();
            while(!pw.equals(u.getPassword())){
                System.out.println("Please re-enter your password");
                pw=bufferedReader.readLine();
            }
            loggedInUser=new User(user,pw);
            System.out.println("You are now signed in as " + user);
        }
        catch (IOException ex){
            System.out.println("error reading");
        }
        return false;
    }
    static String reverseString (String original){
        if(original==null)
            return null;
        StringBuilder result=new StringBuilder();
        char[] word = original.toCharArray();
        int l = word.length-1;
        for (int i = 0; i <= l; i++)
            result.append(word[l-i]);
        return result.toString();
    }
}
