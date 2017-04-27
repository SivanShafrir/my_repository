package com.company;

/**
 * Created by hackeru on 2/19/2017.
 */
public class User {


    String userName;
    String password;


    public static final int ASCII_a = 97;
    public static final int ASCII_z = 122;
    private static final byte ASCII_9 = 57;
    private static final byte ASCII_0 = 48;

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    //בדיקה אם הuserName נכון
    public static boolean checkingUsername(String userName, ArrayList<User> users) {
        byte[] currentByte = userName.getBytes();
        //בודק אם הוסיפו אות
        boolean flagNumbers = false;
        for (int i = 0; i < userName.length(); ) {
            //אא להקיש מספרים
            if ((currentByte[i] >= ASCII_a) && (currentByte[i] <= ASCII_z) && (!flagNumbers))
                i++;
            if ((currentByte[i] >= ASCII_0) && (currentByte[i] <= ASCII_9)) {
                flagNumbers = true;
                i++;
            } else if ((currentByte[i] >= ASCII_a) && (currentByte[i] <= ASCII_z) && (flagNumbers))
                System.out.println("your user name not correct");
            return false;
        }
        boolean a = userExist(userName, users);
        if (a == true)
            return true;
        return false;
    }

    public static boolean userExist(String userName, List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).userName.equals(userName))
                System.out.println("your user name exists");
            return false;
        }
        return true;
    }

    public static boolean checkingPassWord(String password,String confirmPassword) {
        byte[] currentByte = password.getBytes();
        if ((currentByte.length >= 4) && (currentByte.length <= 12)) {
            for (int i = 0; i < currentByte.length; i++) {
                if (!(currentByte[i] >= ASCII_0) && (currentByte[i] >= 128))
                    return false;
            }
            if (password.equals(confirmPassword))
            return true;
        }
        System.out.println("the password dont good ");
        return false;
    }


}