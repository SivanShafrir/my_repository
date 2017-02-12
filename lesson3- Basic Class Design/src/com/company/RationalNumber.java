package com.company;

import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/6/2017.
 */
 public class RationalNumber extends Number {

     private int numerator;
     private int denominator;

    public RationalNumber(int numerator,int denominator) {
        if (denominator==0)
            throw  new InvalidParameterException("division by zero");
        this.numerator=numerator;
        this.denominator=denominator;
    }


    @Override
    public int intValue() {
        return numerator/denominator;
    }

    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    //קודם ממירים לFLOAT ואחכ עושים את החלוקה
    public float floatValue() {
       return (float)numerator/denominator; //ראשית יתבצע המרה לפלוט ואח"כ המחשב יפגוש אינט והוא ימיר אותו לפלוט
    }

    @Override
    public double doubleValue() {
        return(double)numerator/denominator;
    }
    //חיבור של שברים
    public void add(RationalNumber num){
        // מכנה משותף של נאמ והמשתנה של הפונקציה
        int gcd= gcd(this.denominator, num.denominator);//מציאת המחלק המשותף הגדול ביותר
        int a=this.denominator/gcd;// מכנה/ מכנה משותף
        int b=num.denominator/gcd;
        this.denominator*=b;
        this.numerator*=b;
        this.numerator+=num.numerator*a;
        //מחברים את המונה והמכנה נשאר אותו דבר לאחר ההרחבה
        reduce();//לצמצם את השבר לאחר החיבור עובד על האוביקט של המחלקה
    }

    //צמצום שברים
    public void reduce(){
        int gcd= gcd(this.denominator, this.numerator);//מציאת המחלק המשותף הגדול ביותר
        this.denominator/= gcd;
        this.numerator/=gcd;
    }

    // מציאת המחלק המשותף הגדול ביותר
    public static int gcd(int x, int y){
        if(x==0)
            return y;
        return gcd(y%x, x );
    }


}
