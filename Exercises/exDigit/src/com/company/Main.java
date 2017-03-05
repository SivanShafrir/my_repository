package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

//מקבלת מספר ומחזירה את סכום הספרות שלו
    static int sumOfDigits (int num)
    {
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    static int finalSumOfDigits(int num){
        int n=sumOfDigits(num);
        while(n>9)
            n=sumOfDigits(n);
        return n;
    }
    static int largestDigit (int num){
        int res=0;
        while(num>0){
            if(num%10>res)
                res=num%10;
            num/=10;
        }
        return res;
    }
    static int reverseDigits (int num){
        int rev=0;
        int mone=1;
        while (num>0){
            rev+=(num%10)*(mone);
            num/=10;
            mone*=10;
        }
        return rev;
    }
    static boolean divby3 (int num){
        if (num<0)
            return divby3(-num);
        if(num==0 || num==3 || num==6 || num==9) return true;
        if(num<10) return false;
        return divby3(finalSumOfDigits(num));
    }
}