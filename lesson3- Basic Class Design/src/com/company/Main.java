package com.company;

import graphicshape.*;

public class Main {

    public static void main(String[] args) {
        // Circle circle1= new Circle(); //המשתנה CIRCLE  (כאן המחשב נותן תשובה כיון שכל השדות מקבלים ערך "0")
        Circle circle1;//מכיל כתובת בזיכרון, מצביע (לא יוצר אובייקט)
        circle1 = new Circle();
        //System.out.println(circle1.x);// אי אפשר לגשת לאיקס כיוון שהוא דיפולט והאיקס מוגדר בפאקטג אחר
        System.out.println(circle1.toString());//יש בתוך הפריט ליין הגדרה שידפיס את הTOSTRING של האובייקט
        System.out.println(circle1.area());// מכיוון שהגדרנו את הפונקצית AREA כציבורי ניתן לגשת אליו מכל מקום
        // יום הולדת שמח
        HappyBirthday.whish("sivan");// אפשר לשלוח ישר לWISH כי הגדרנו אותה סטטית
        HappyBirthday.whish();

        Number[] nums = {5, 7, 4.3f, new Double(3), new RationalNumber(5, 2)};
        System.out.println(sum(nums));


        //Square
        Square square = new Square(5);
        square.setHeight(15);
        // System.out.println(square.getWidth());
        System.out.println(square.area());
        System.out.println(square.perimeter());

        Shape s= new Square(6);// sהאבא יכול להצביע על אובייקט מהסוג של הבן, הוא מפעיל את הקונסטרקטור של הריבוע אבל שומר את הכתובת ב
        // בשלב הקומפילציה הןא מסתכל על סוג המצביע שיש לי ואם אין לי את המתודה בסוג של המצביע הוא לא יוכל להפעיל אותה
       // s.setSide(5);// רשימת המתודות שניתן להפעיל על אובייקט נקבעת לפי סוג המצביע -טעות
       // Circle c = new Square(3); //בגאווה סוג המצביע וסוג האובייקט לא חייבים להיות מאותו סוג אבל צריך להיות ביניהם קשר
        // אם עברתי את שלב הקומפילציה אז הוא  מסתכל על סוג האובייקט שליש לי בעצם ולא משנה לו הסוג של במצביע
        System.out.println(s.area());// ידפיס 36 כלומר בפועל הופעלה המתודה של הריבוע כי בעצם מה שיש לי זה ריבוע ולא שורה זה בגלל שעברתי את שלב הקומפילציה

      //פרמטר של מערך ופרמטר של פונקציה זה מקרים שנוכל לראות שסוג המצביע וסוג האובייקט לא אותו דבר

    //אנימל
        Animal a= new Poodle();//מה שמופעל בפועל זה לפי האובייקט שיש בפועל של הפודל אבל המצביע זה של האינמל
        a.makeSound();

        Circle c=new Circle(3,4,10);
        c.setRadius(6);
        Segment segment = new Segment(new Point(4,5), new Point(7,4));
        segment.A();

        // אלייסינג- aliasing
        Point p = new Point(4,5);
        Segment segment1 =  new Segment(p,new Point(7,4));
        p.setX(19);//שני פוינטרים שמצביעים לאותו אובייקט ושיניתי את הערך שך X ללא ידיעתו של הסיגמנט ובעצם עקפתי את הפרייבט של השדות

        Point p1= new Point(p);//מעתיק את P לP1
    }

    //מקבלת מערך של נאמברים וצריכה להחזיר את הסכום שלהם
    public static double sum(Number[] nums) {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            Number num = nums[i];
            sum += num.doubleValue();//לא אכפת לה שכל נאמבר הוא מסוג אחר העיקר שיש בהם את הפונקציה הזאת שממירה את הנאמבר לדאבל
        }
        return sum;
    }
     //אותו דבר כמו הקודם על לולאת FOREACH
    public static double sum1(Number[] nums) {
        double sum = 0.0;
        //לולאת FOREACH הגדרנו מצביע מסוג נאמבר שרץ על איברי המערך שהוא מערך של אובייקטים
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

}

class Animal{
    void makeSound(){
        System.out.println("aaaaa");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("waf waf");
    }

    @Override
    void makeSound() {
        bark();
    }
}

class Cat extends Animal{
    void howl(){
        System.out.println("grrrrrrr....");
    }

    @Override
    void makeSound() {
        howl();
    }
}

class Poodle extends Dog{
    @Override
    void bark() {
        System.out.println("bfff.. bffff..");
    }
}

