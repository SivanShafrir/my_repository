package com.company;

public class Main {

    public static void main(String[] args) {

        MyString myString = new MyString ( new char [] {'H','e','l','l','o',' ','S','a','r','a','h'} );
        MyString Sarah = new MyString ( new char [] {'S','a','r','a','h'} );

        System.out.println(myString.indexOf(Sarah));

        print(myString.split(' '));
    }
    public static void print (MyString[] toPrint){
        for (int i = 0; i < toPrint.length; i++) {
            for (int j = 0; j < toPrint[i].arr.length; j++) {
                System.out.print(toPrint[i].arr[j]);
            }
            System.out.println();
        }
    }
}
